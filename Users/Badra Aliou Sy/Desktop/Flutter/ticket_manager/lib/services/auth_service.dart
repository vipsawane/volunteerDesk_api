import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:firebase_auth/firebase_auth.dart';

class AuthService {
  final FirebaseAuth _auth = FirebaseAuth.instance;
  final FirebaseFirestore _firestore = FirebaseFirestore.instance;

  // Méthode de connexion avec email et mot de passe
  Future<User?> connexionAvecMotdepasse(String email, String password) async {
    try {
      UserCredential result = await _auth.signInWithEmailAndPassword(
          email: email, password: password);
      return result.user;
    } catch (e) {
      print('Erreur lors de la connexion: $e');
      return null;
    }
  }

  // Méthode pour récupérer les informations utilisateur depuis Firestore
  Future<Map<String, dynamic>?> recupererInformationsUtilisateur(String uid) async {
    try {
      DocumentSnapshot snapshot = 
          await _firestore.collection('user').doc(uid).get();

      if (snapshot.exists) {
        return snapshot.data() as Map<String, dynamic>?;
      } else {
        print('Document utilisateur non trouvé');
        return null;
      }
    } catch (e) {
      print('Erreur lors de la récupération des informations utilisateur: $e');
      return null;
    }
  }

  // Méthode pour récupérer le rôle de l'utilisateur
  Future<String?> recupererRoleUtilisateur(String uid) async {
    try {
      DocumentSnapshot snapshot =
          await _firestore.collection('user').doc(uid).get();

      if (snapshot.exists) {
        Map<String, dynamic>? data = snapshot.data() as Map<String, dynamic>?;
        if (data != null && data.containsKey('role')) {
          return data['role'] as String?;
        } else {
          print('Le champ "role" est manquant');
          return null;
        }
      } else {
        print('Document utilisateur non trouvé');
        return null;
      }
    } catch (e) {
      print('Erreur lors de la récupération du rôle : $e');
      return null;
    }
  }
}
