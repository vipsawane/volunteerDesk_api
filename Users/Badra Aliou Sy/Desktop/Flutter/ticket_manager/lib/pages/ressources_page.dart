import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/material.dart';
import 'package:ticket_manager/pages/navbar_page.dart';
import 'package:ticket_manager/models/users.model.dart';
import 'package:ticket_manager/services/ticket_service.dart';
import 'package:ticket_manager/models/ticket_model.dart';

class RessourcesPage extends StatefulWidget {
  const RessourcesPage({super.key});

  @override
  State<RessourcesPage> createState() => _RessourcesPageState();
}

class _RessourcesPageState extends State<RessourcesPage> {
  late UserModel user;

  @override
  void initState() {
    super.initState();
    _fetchUser();
  }

  void _fetchUser() async {
    final firebaseUser = FirebaseAuth.instance.currentUser;
    if (firebaseUser != null) {
      user = await fetchUserDetails(firebaseUser.uid);
      setState(() {});
    }
  }

  Future<UserModel> fetchUserDetails(String uid) async {
    // Implémentez la logique pour récupérer les détails de l'utilisateur
    return UserModel(
      id: uid,
      email: "example@example.com",
      password: "123",
      prenom: "John",
      nom: "Doe",
      telephone: "123456789",
      role: RoleUser.Admin,
    );
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.blue,
        title: const Text('Tickets Résolus', textAlign: TextAlign.center),
      ),
      drawer: user == null
          ? const CircularProgressIndicator()
          : NavBarPage(
              user: user,
              onLogout: () {
                FirebaseAuth.instance.signOut();
                Navigator.pushReplacementNamed(context, '/login');
              },
            ),
      body: StreamBuilder<List<TicketModel>>(
        stream: TicketService().ticketResolu, // Utilisez le flux des tickets résolus
        builder: (context, snapshot) {
          if (snapshot.connectionState == ConnectionState.waiting) {
            return const Center(child: CircularProgressIndicator());
          } else if (snapshot.hasError) {
            return Center(child: Text('Erreur : ${snapshot.error}'));
          } else if (!snapshot.hasData || snapshot.data!.isEmpty) {
            return const Center(child: Text('Aucun ticket résolu trouvé.'));
          }

          final tickets = snapshot.data!;

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
                      Text('Catégorie: ${ticket.categorie}'),
                      Text('Date: ${ticket.date_creation.toLocal().toString().split(' ')[0]}'),
                      Text('Statut: ${ticket.status}'),
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
