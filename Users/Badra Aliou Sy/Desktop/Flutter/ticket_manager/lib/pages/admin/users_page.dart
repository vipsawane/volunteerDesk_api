import 'package:flutter/material.dart';
import 'package:ticket_manager/services/users_service.dart';
import 'package:ticket_manager/models/users.model.dart';

class UsersPage extends StatefulWidget {
  const UsersPage({super.key});

  @override
  State<UsersPage> createState() => _UsersPageState();
}

class _UsersPageState extends State<UsersPage> {
  final _nomController = TextEditingController();
  final _prenomController = TextEditingController();
  final _emailController = TextEditingController();
  final _telephoneController = TextEditingController();
  final _passwordController = TextEditingController();
  RoleUser? _role;

  final UsersService _usersService = UsersService();

  void _submitUser() async {
    if (_nomController.text.isNotEmpty &&
        _prenomController.text.isNotEmpty &&
        _emailController.text.isNotEmpty &&
        _telephoneController.text.isNotEmpty &&
        _passwordController.text.isNotEmpty &&
        _role != null) {
      try {
        await _usersService.addUser(
          _nomController.text,
          _prenomController.text,
          _emailController.text,
          _telephoneController.text,
          _passwordController.text,
          _role!,
        );
        // Afficher un message de succès
        ScaffoldMessenger.of(context).showSnackBar(
          const SnackBar(content: Text('Utilisateur ajouté avec succès')),
        );
        // Retourner à la page précédente après l'ajout
        Navigator.pop(context);
      } catch (e) {
        // Gérer les erreurs lors de l'ajout
        ScaffoldMessenger.of(context).showSnackBar(
          SnackBar(content: Text('Erreur lors de l\'ajout de l\'utilisateur : $e')),
        );
      }
    } else {
      // Afficher un message d'erreur si des champs sont manquants
      ScaffoldMessenger.of(context).showSnackBar(
        const SnackBar(content: Text('Veuillez remplir tous les champs et sélectionner un rôle')),
      );
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Ajouter un Utilisateur'),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          children: [
            TextField(
              controller: _nomController,
              decoration: const InputDecoration(labelText: 'Nom'),
            ),
            TextField(
              controller: _prenomController,
              decoration: const InputDecoration(labelText: 'Prénom'),
            ),
            TextField(
              controller: _emailController,
              decoration: const InputDecoration(labelText: 'Email'),
            ),
            TextField(
              controller: _telephoneController,
              decoration: const InputDecoration(labelText: 'Téléphone'),
            ),
            TextField(
              controller: _passwordController,
              decoration: const InputDecoration(labelText: 'Mot de passe'),
              obscureText: true,
            ),
            DropdownButton<RoleUser>(
              hint: const Text('Sélectionner un rôle'),
              value: _role,
              items: RoleUser.values.map((role) {
                return DropdownMenuItem(
                  value: role,
                  child: Text(role.toString().split('.').last),
                );
              }).toList(),
              onChanged: (value) {
                setState(() {
                  _role = value;
                });
              },
            ),
            const SizedBox(height: 20),
            ElevatedButton(
              onPressed: _submitUser,
              child: const Text('Ajouter'),
            ),
          ],
        ),
      ),
    );
  }
}
