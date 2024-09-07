import 'package:flutter/foundation.dart';
import 'package:uuid/uuid.dart';

// Déclaration des énumérations
enum StatutTicket { en_attente, en_cours, resolu }
enum CategorieTicket { technique, pedagogique }

class TicketModel {
  final String id;
  final String titre;
  final String description;
  final CategorieTicket categorie;
  final DateTime date_creation;
  final StatutTicket status;

  // Constructeur principal
  TicketModel({
    String? id,
    required this.titre,
    required this.description,
    required this.categorie,
    DateTime? date_creation,
    StatutTicket? status,
  })  : id = id ?? Uuid().v4(), // Génère un ID unique si non fourni
        date_creation = date_creation ?? DateTime.now(), // Génère la date actuelle si non fournie
        status = status ?? StatutTicket.en_attente; // Définit le statut par défaut à "en attente"

  // Factory pour créer un `TicketModel` à partir d'une map (ex. depuis Firebase)
  factory TicketModel.fromMap(Map<String, dynamic> data) {
    return TicketModel(
      id: data['id'],
      titre: data['titre'],
      description: data['description'],
      categorie: CategorieTicket.values.firstWhere((e) => e.toString() == 'CategorieTicket.${data['categorie']}'),
      date_creation: DateTime.parse(data['date_creation']), // Conversion de la chaîne en DateTime
      status: StatutTicket.values.firstWhere((e) => e.toString() == 'StatutTicket.${data['status']}'),
    );
  }

  // Convertir le `TicketModel` en map pour l'enregistrement dans Firebase
  Map<String, dynamic> toMap() {
    return {
      'id': id,
      'titre': titre,
      'description': description,
      'categorie': categorie.toString().split('.').last, // Convertir enum en chaîne
      'date_creation': date_creation.toIso8601String(), // Convertir DateTime en chaîne ISO
      'status': status.toString().split('.').last, // Convertir enum en chaîne
    };
  }
}
