// import 'package:firebase_messaging/firebase_messaging.dart';

// class NotificationService {
//   final FirebaseMessaging _firebaseMessaging = FirebaseMessaging.instance;

//   void initialize() {
//     FirebaseMessaging.onMessage.listen((RemoteMessage message) {
//       print('Message reçu: ${message.messageId}');
//       // Afficher la notification dans l'application
//     });
//   }

//   Future<void> getToken() async {
//     String? token = await _firebaseMessaging.getToken();
//     print('Token de notification: $token');
//   }
// }
