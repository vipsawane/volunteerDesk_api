import 'package:flutter/material.dart';

class DeconnexionPage extends StatelessWidget {
  const DeconnexionPage({super.key});

  @override
  Widget build(BuildContext context) {
    void _logout() {
      Navigator.pushReplacementNamed(context, '/login');
    }

    return Scaffold(
      appBar: AppBar(
        title: const Text('Déconnexion'),
        backgroundColor: Colors.redAccent,
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            const Text(
              'Êtes-vous sûr de vouloir vous déconnecter ?',
              style: TextStyle(fontSize: 18),
            ),
            const SizedBox(height: 20),
            ElevatedButton(
              onPressed: _logout,
              style: ElevatedButton.styleFrom(
                backgroundColor: Colors.redAccent,
                padding: const EdgeInsets.symmetric(horizontal: 50, vertical: 15),
                shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(12),
                ),
              ),
              child: const Text('Oui, déconnectez-moi'),
            ),
            TextButton(
              onPressed: () {
                Navigator.pop(context); // Retourner à la page précédente
              },
              child: const Text('Annuler'),
            ),
          ],
        ),
      ),
    );
  }
}
