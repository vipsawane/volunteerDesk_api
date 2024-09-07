import 'package:flutter/material.dart';
import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:ticket_manager/services/ticket_service.dart';
import 'package:ticket_manager/models/ticket_model.dart';

class TicketListPage extends StatefulWidget {
  const TicketListPage({super.key});

  @override
  _TicketListPageState createState() => _TicketListPageState();
}

class _TicketListPageState extends State<TicketListPage> {
  final TicketService _ticketService = TicketService();
  final TextEditingController _searchController = TextEditingController();
  String _searchQuery = '';

  @override
  void initState() {
    super.initState();
    _searchController.addListener(() {
      setState(() {
        _searchQuery = _searchController.text.toLowerCase();
      });
    });
  }

  @override
  void dispose() {
    _searchController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Liste des Tickets'),
        bottom: PreferredSize(
          preferredSize: const Size.fromHeight(56.0),
          child: Padding(
            padding: const EdgeInsets.symmetric(horizontal: 16.0),
            child: TextField(
              controller: _searchController,
              decoration: InputDecoration(
                hintText: 'Rechercher...',
                border: OutlineInputBorder(
                  borderRadius: BorderRadius.circular(10.0),
                ),
                suffixIcon: const Icon(Icons.search),
              ),
            ),
          ),
        ),
      ),
      body: StreamBuilder<List<TicketModel>>(
        stream: _ticketService.ticketStream,
        builder: (context, snapshot) {
          if (snapshot.connectionState == ConnectionState.waiting) {
            return const Center(child: CircularProgressIndicator());
          } else if (snapshot.hasError) {
            return Center(child: Text('Erreur : ${snapshot.error}'));
          } else if (!snapshot.hasData || snapshot.data!.isEmpty) {
            return const Center(child: Text('Aucun ticket trouvé.'));
          }

          final tickets = snapshot.data!
              .where((ticket) =>
                  ticket.titre.toLowerCase().contains(_searchQuery) ||
                  ticket.description.toLowerCase().contains(_searchQuery))
              .toList();

          return ListView.builder(
            itemCount: tickets.length,
            itemBuilder: (context, index) {
              final ticket = tickets[index];
              return Card(
                margin: const EdgeInsets.symmetric(vertical: 8.0, horizontal: 16.0),
                child: ListTile(
                  contentPadding: const EdgeInsets.all(16.0),
                  title: Text(ticket.titre, style: const TextStyle(fontWeight: FontWeight.bold)),
                  subtitle: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      Text('Description: ${ticket.description}'),
                      Text('Catégorie: ${ticket.categorie.toString().split('.').last}'),
                      Text('Date: ${ticket.date_creation.toLocal().formatDate()}'),
                      Text('Statut: ${ticket.status.toString().split('.').last}'),
                    ],
                  ),
                  isThreeLine: true,
                ),
              );
            },
          );
        },
      ),
    );
  }
}

extension DateTimeFormatting on DateTime {
  String formatDate() {
    return "${this.day}/${this.month}/${this.year}";
  }
}
