import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/material.dart';
import 'package:ticket_manager/pages/navbar_page.dart';
import 'package:ticket_manager/models/users.model.dart';

class DiscussionsPage extends StatefulWidget {
  const DiscussionsPage({super.key});

  @override
  State<DiscussionsPage> createState() => _DiscussionsPageState();
}

class _DiscussionsPageState extends State<DiscussionsPage> {
  late UserModel user;

  @override
  void initState() {
    super.initState();
    _fetchUser();
  }

  void _fetchUser() async {
    final firebaseUser = FirebaseAuth.instance.currentUser;
    if (firebaseUser != null) {
      user = await fetchUserDetails(firebaseUser.uid); // Remplacez par votre propre méthode
      setState(() {});
    }
  }

  Future<UserModel> fetchUserDetails(String uid) async {
    // Implémentez la logique pour récupérer les détails de l'utilisateur depuis Firestore ou un autre service
    // Exemple fictif :
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
        title: const Text('Discussions', textAlign: TextAlign.center),
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
      body: Center(
        child: Text('Page des discussions'),
      ),
    );
  }
}
