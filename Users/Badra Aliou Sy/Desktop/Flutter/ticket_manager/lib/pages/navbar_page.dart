import 'package:flutter/material.dart';
import 'package:ticket_manager/models/users.model.dart';

class NavBarPage extends StatelessWidget {
  final UserModel user;
  final VoidCallback onLogout;

  const NavBarPage({
    super.key,
    required this.user,
    required this.onLogout,
  });

  @override
  Widget build(BuildContext context) {
    // Extraire les initiales à partir du profil utilisateur
    String initiales = "${user.prenom[0]}${user.nom[0]}";

    return Drawer(
      child: ListView(
        padding: EdgeInsets.zero,
        children: [
          UserAccountsDrawerHeader(
            accountName: Text('${user.prenom} ${user.nom}'),
            accountEmail: Text(user.email),
            currentAccountPicture: CircleAvatar(
              backgroundColor: Colors.blue, // Couleur de fond du cercle
              child: Text(
                initiales,
                style: const TextStyle(
                  fontSize: 24, // Taille du texte des initiales
                  fontWeight: FontWeight.bold,
                  color: Colors.white, // Couleur du texte
                ),
              ),
            ),
          ),
          // Affiche l'option "Admin" si l'utilisateur est un admin
          if (user.role == 'Admin') ...[
            ListTile(
              leading: const Icon(Icons.dashboard),
              title: const Text('Admin'),
              onTap: () {
                Navigator.pushNamed(context, '/admin');
              },
            ),
          ],
          // Affiche l'option "Formateur" si l'utilisateur est un formateur
          if (user.role == 'Formateur') ...[
            ListTile(
              leading: const Icon(Icons.school),
              title: const Text('Formateur'),
              onTap: () {
                Navigator.pushNamed(context, '/formateur');
              },
            ),
          ],
          // Affiche l'option "Apprenant" si l'utilisateur est un apprenant
          if (user.role == 'Apprenant') ...[
            ListTile(
              leading: const Icon(Icons.person),
              title: const Text('Apprenant'),
              onTap: () {
                Navigator.pushNamed(context, '/apprenant');
              },
            ),
          ],
          // Options communes à tous les rôles
          ListTile(
            leading: const Icon(Icons.book),
            title: const Text('Ressources'),
            onTap: () {
              Navigator.pushNamed(context, '/ressources');
            },
          ),
          ListTile(
            leading: const Icon(Icons.notifications),
            title: const Text('Notifications'),
            onTap: () {
              Navigator.pushNamed(context, '/notifications');
            },
          ),
          ListTile(
            leading: const Icon(Icons.chat),
            title: const Text('Discussions'),
            onTap: () {
              Navigator.pushNamed(context, '/discussions');
            },
          ),
          //Deconnexion
          ListTile(
            leading: const Icon(Icons.exit_to_app),
            title: const Text('Déconnexion'),
            onTap: onLogout,
          ),
        ],
      ),
    );
  }
}
