import 'package:flutter/material.dart';
import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:ticket_manager/services/ticket_service.dart';
import 'package:ticket_manager/models/ticket_model.dart';

class TicketCreerPage extends StatefulWidget {
  const TicketCreerPage({super.key});

  @override
  State<TicketCreerPage> createState() => _TicketCreerPageState();
}

class _TicketCreerPageState extends State<TicketCreerPage> {
  final _titreController = TextEditingController();
  final _descriptionController = TextEditingController();
  CategorieTicket? _categorie; 

  final TicketService _ticketService = TicketService();

  void _submitTicket() async {
  if (_titreController.text.isNotEmpty &&
      _descriptionController.text.isNotEmpty &&
      _categorie != null) {
    try {
      await _ticketService.addTicket(
        _titreController.text,
        _descriptionController.text,
        _categorie!,
      );
      Navigator.pop(context);
    } catch (e) {
      print("Error while adding ticket: $e");
      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(content: Text('Erreur: $e')),
      );
    }
  } else {
    ScaffoldMessenger.of(context).showSnackBar(
      const SnackBar(content: Text('Veuillez remplir tous les champs et sélectionner une catégorie')),
    );
  }
}



  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Créer un Ticket'),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          children: [
            TextField(
              controller: _titreController,
              decoration: const InputDecoration(labelText: 'Titre'),
            ),
            TextField(
              controller: _descriptionController,
              decoration: const InputDecoration(labelText: 'Description'),
              maxLines: 5,
            ),
            DropdownButton<CategorieTicket>(
              hint: const Text('Sélectionner une catégorie'),
              value: _categorie,
              items: CategorieTicket.values.map((categorie) {
                return DropdownMenuItem(
                  value: categorie,
                  child: Text(categorie.toString().split('.').last),
                );
              }).toList(),
              onChanged: (value) {
                setState(() {
                  _categorie = value;
                });
              },
            ),
            ElevatedButton(
              onPressed: _submitTicket,
              child: const Text('Soumettre'),
            ),
          ],
        ),
      ),
    );
  }
}
