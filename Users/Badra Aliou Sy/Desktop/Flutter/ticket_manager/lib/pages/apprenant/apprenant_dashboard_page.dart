import 'package:flutter/material.dart';
import 'package:ticket_manager/pages/apprenant/ticket_creer_page.dart';
import 'package:ticket_manager/pages/apprenant/ticket_list_page.dart';
import 'package:ticket_manager/pages/deconnexion_page.dart';
import 'package:ticket_manager/pages/navbar_page.dart';
import 'package:ticket_manager/models/users.model.dart';

class ApprenantDashboardPage extends StatefulWidget {
  const ApprenantDashboardPage({super.key});

  @override
  State<ApprenantDashboardPage> createState() => _ApprenantDashboardPageState();
}

class _ApprenantDashboardPageState extends State<ApprenantDashboardPage> {
  @override
  Widget build(BuildContext context) {
    UserModel user = UserModel(
      id: '3',
      email: 'apprenant@example.com',
      password: '123',
      nom: 'Diarra',
      prenom: 'Marie',
      telephone: '1234567890',
      role: RoleUser.Apprenant, // Utilisation de l'énumération RoleUser
    );

    void handleLogout() {
      Navigator.pushReplacementNamed(context, '/login');
    }

    void handleCreateTicket() async {
      await Navigator.push(
        context,
        MaterialPageRoute(builder: (context) => const TicketCreerPage()),
      );
      Navigator.pushReplacement(
        context,
        MaterialPageRoute(builder: (context) => const TicketListPage()),
      );
    }

    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.blue,
        title: const Center(
          child: Text('Dashboard'),
        ),
      ),
      drawer: NavBarPage(
        user: user,
        onLogout: () {
          Navigator.push(
            context,
            MaterialPageRoute(builder: (context) => const DeconnexionPage()),
          );
        },
      ),
      body: const Center(
        child: Text(
          'Bienvenue sur le tableau de bord de l\'apprenant',
          style: TextStyle(fontSize: 20.0),
        ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: handleCreateTicket,
        child: const Icon(Icons.add),
        tooltip: 'Créer un nouveau ticket',
      ),
      floatingActionButtonLocation: FloatingActionButtonLocation.endFloat,
    );
  }
}
