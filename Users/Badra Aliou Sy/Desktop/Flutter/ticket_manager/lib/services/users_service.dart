import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:firebase_auth/firebase_auth.dart';
import 'package:ticket_manager/models/users.model.dart';

class UsersService {
  final CollectionReference userCollection = FirebaseFirestore.instance.collection("user");
  final FirebaseAuth _auth = FirebaseAuth.instance;

  // Ajouter un utilisateur
  Future<DocumentReference> addUser(String nom, String prenom, String email, String telephone, String password, RoleUser role) async {
    try {
      UserCredential userCredential = await _auth.createUserWithEmailAndPassword(
        email: email,
        password: password,
      );

      // Création de l'utilisateur avec UID de Firebase Auth
      await userCollection.doc(userCredential.user!.uid).set({
        'uid': userCredential.user!.uid,
        'nom': nom,
        'prenom': prenom,
        'email': email,
        'telephone': telephone,
        'password': password,
        'role': role.toString().split('.').last,
      });

      return userCollection.doc(userCredential.user!.uid);
    } catch (e) {
      print('Erreur lors de l\'ajout de l\'utilisateur: ${e.toString()}');
      rethrow;
    }
  }

  // Récupérer le rôle d'un utilisateur
  Future<String?> recupererRoleUtilisateur(String uid) async {
    try {
      DocumentSnapshot snapshot = await userCollection.doc(uid).get();
      
      if (snapshot.exists) {
        Map<String, dynamic> data = snapshot.data() as Map<String, dynamic>;
        return data['role'] as String?;
      } else {
        print('Le document pour l\'UID $uid n\'existe pas');
        return null;
      }
    } catch (e) {
      print('Erreur lors de la récupération du rôle pour l\'UID $uid: ${e.toString()}');
      return null;
    }
  }

  // Modifier un utilisateur
  Future<void> modifierUser(String id, String nom, String prenom, String email, String telephone, String password, RoleUser role) async {
    try {
      await userCollection.doc(id).update({
        'nom': nom,
        'prenom': prenom,
        'email': email,
        'telephone': telephone,
        'password': password,
        'role': role.toString().split('.').last,
      });
    } catch (e) {
      print('Erreur lors de la modification de l\'utilisateur avec l\'ID $id: ${e.toString()}');
    }
  }

  // Supprimer un utilisateur
  Future<void> supprimerUser(String id) async {
    try {
      await userCollection.doc(id).delete();
    } catch (e) {
      print('Erreur lors de la suppression de l\'utilisateur avec l\'ID $id: ${e.toString()}');
    }
  }

  // Récupérer les utilisateurs par rôle
  Stream<List<UserModel>> getUsersByRole(String role) {
    return userCollection
        .where('role', isEqualTo: role)
        .snapshots()
        .map(_userFromSnapshot);
  }

  // Conversion des snapshots en liste de UserModel
  List<UserModel> _userFromSnapshot(QuerySnapshot snapshot) {
    return snapshot.docs.map((doc) {
      return UserModel.fromMap(doc.data() as Map<String, dynamic>);
    }).toList();
  }
}
