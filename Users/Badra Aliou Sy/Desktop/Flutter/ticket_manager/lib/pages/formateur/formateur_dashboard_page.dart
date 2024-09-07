import 'package:flutter/material.dart';
import 'package:ticket_manager/pages/deconnexion_page.dart';
import 'package:ticket_manager/pages/navbar_page.dart';
import 'package:ticket_manager/models/users.model.dart';

class FormateurDashboardPage extends StatefulWidget {
  const FormateurDashboardPage({super.key});

  @override
  State<FormateurDashboardPage> createState() => _FormateurDashboardPageState();
}

class _FormateurDashboardPageState extends State<FormateurDashboardPage> {
  @override
  Widget build(BuildContext context) {
    // Exemple d'utilisateur pour la démonstration
    UserModel user = UserModel(
      id: '2',
      email: 'formateur@example.com',
      password: '123',
      nom: 'Formateur',
      prenom: 'Jean',
      telephone: '987654321',
      role: RoleUser.Formateur, // Utilisation de l'énumération RoleUser
    );

    void handleLogout() {
      Navigator.pushReplacementNamed(context, '/login');
    }

    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.blue,
        title: Center(
          child: Text('Dashboard'),
        )
      ),
      drawer: NavBarPage(
        user: user,
      onLogout: () {
            Navigator.push(
          context,
          MaterialPageRoute(builder: (context) => const DeconnexionPage()),
            );
          },      ),
      body: const Center(
        child: Text(
          'Bienvenue sur le tableau de bord du formateur',
          style: TextStyle(fontSize: 20.0),
        ),
      ),
    );
  }
}
