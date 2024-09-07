import 'package:flutter/material.dart';
import 'package:ticket_manager/pages/admin/users_page.dart';
import 'package:ticket_manager/pages/deconnexion_page.dart';
import 'package:ticket_manager/pages/navbar_page.dart';
import 'package:ticket_manager/models/users.model.dart';

class AdminDashboardPage extends StatefulWidget {
  const AdminDashboardPage({super.key});

  @override
  State<AdminDashboardPage> createState() => _AdminDashboardPageState();
}

class _AdminDashboardPageState extends State<AdminDashboardPage> {
  @override
  Widget build(BuildContext context) {
    // Exemple d'utilisateur pour la démonstration
    UserModel user = UserModel(
      id: '1',
      email: 'admin@example.com',
      password: '12345678',
      prenom: 'Morin',
      nom: 'Oumar',
      telephone: '123456789',
      role: RoleUser.Admin, // Utilisation de l'énumération RoleUser
);

    void handleLogout() {
      Navigator.push(
        context,
        MaterialPageRoute(builder: (context) => const DeconnexionPage()),
      );
    }

    void handleCreateUser() async {
      // Naviguer vers la page de création d'utilisateur
      await Navigator.push(
        context,
        MaterialPageRoute(builder: (context) => const UsersPage()),
      );
      // Vous pouvez mettre à jour les données ou rediriger vers une autre page après la création
      // Par exemple, vous pouvez recharger les données ici
    }

    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.blue,
        title: const Text('Dashboard', textAlign: TextAlign.center),
      ),
      drawer: NavBarPage(
        user: user,
        onLogout: handleLogout,
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            const Text(
              'Bienvenue sur le Dashboard Admin',
              style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
            ),
            const SizedBox(height: 20),
            Card(
              elevation: 5,
              shape: RoundedRectangleBorder(
                borderRadius: BorderRadius.circular(10),
              ),
              child: Container(
                width: 300,
                height: 150,
                padding: const EdgeInsets.all(16),
                child: Column(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: const [
                    Text(
                      'Statistiques récentes',
                      style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold),
                    ),
                    SizedBox(height: 10),
                    Text('Nombre de tickets créés : 50'),
                    Text('Tickets résolus : 30'),
                  ],
                ),
              ),
            ),
          ],
        ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: handleCreateUser,
        child: const Icon(Icons.add),
        tooltip: 'Ajouter un utilisateur',
      ),
      floatingActionButtonLocation: FloatingActionButtonLocation.endFloat,
    );
  }
}
