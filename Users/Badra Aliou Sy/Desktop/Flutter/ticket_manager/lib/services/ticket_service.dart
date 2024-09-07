import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:firebase_auth/firebase_auth.dart';
import 'package:ticket_manager/models/ticket_model.dart';

class TicketService {
  final CollectionReference ticketCollection = FirebaseFirestore.instance.collection("ticket");

  User? user = FirebaseAuth.instance.currentUser;


  Future<void> addTicket(String titre, String description, CategorieTicket categorie) async {
  try {
    await ticketCollection.add({
      'titre': titre,
      'description': description,
      'categorie': categorie.toString().split('.').last,
      'status': 'en_attente',
      'date_creation': FieldValue.serverTimestamp(),
    });
  } catch (e) {
    throw Exception('Erreur lors de l\'ajout du ticket : $e');
  }
  }


  // Modifier Ticket
  Future<void> modifierTicket(String id, String titre, String description, CategorieTicket categorie) async {
    return await ticketCollection.doc(id).update({
      'titre': titre,
      'description': description,
      'categorie': categorie.toString().split('.').last,
    });
  }

  // Supprimer Ticket
  Future<void> supprimerTicket(String id) async {
    return await ticketCollection.doc(id).delete();
  }

  // Liste des tickets par catégorie technique
  Stream<List<TicketModel>> get ticketParCategorieTechnique {
    return ticketCollection
        .where('uid', isEqualTo: user!.uid)
        .where('categorie', isEqualTo: 'technique')
        .snapshots()
        .map(_ticketFromSnapshot);
  }

  // Liste des tickets par catégorie pédagogique
  Stream<List<TicketModel>> get ticketParCategoriePedagogique {
    return ticketCollection
        .where('uid', isEqualTo: user!.uid)
        .where('categorie', isEqualTo: 'pedagogique')
        .snapshots()
        .map(_ticketFromSnapshot);
  }

  // Conversion des snapshots en Liste de `TicketModel`
  List<TicketModel> _ticketFromSnapshot(QuerySnapshot snapshot) {
    return snapshot.docs.map((doc) {
      return TicketModel.fromMap(doc.data() as Map<String, dynamic>);
    }).toList();
  }

  // Liste des tickets résolus
  Stream<List<TicketModel>> get ticketResolu {
    return ticketCollection
        .where('uid', isEqualTo: user!.uid)
        .where('status', isEqualTo: 'resolu')
        .snapshots()
        .map(_ticketFromSnapshot);
  }

  get ticketStream => null;
}
