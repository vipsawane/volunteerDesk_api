import 'package:flutter/material.dart';
import 'package:firebase_core/firebase_core.dart';
import 'package:ticket_manager/pages/admin/admin_dashboard_page.dart';
import 'package:ticket_manager/pages/apprenant/apprenant_dashboard_page.dart';
import 'package:ticket_manager/pages/connexion_page.dart';
import 'package:ticket_manager/pages/deconnexion_page.dart';
import 'package:ticket_manager/pages/discussions_page.dart';
import 'package:ticket_manager/pages/formateur/formateur_dashboard_page.dart';
import 'package:ticket_manager/firebase_options.dart';
import 'package:ticket_manager/pages/notifications_page.dart';
import 'package:ticket_manager/pages/ressources_page.dart';

void main() async {
  WidgetsFlutterBinding.ensureInitialized();
  await Firebase.initializeApp(
    options: DefaultFirebaseOptions.currentPlatform,
  );
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Ticket Manager',
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        primarySwatch: Colors.indigo,
        primaryColor: Colors.indigo,
      ),
      initialRoute: '/apprenant', 
      routes: {
        '/login': (context) => const ConnexionPage(),
        '/admin': (context) => const AdminDashboardPage(),
        '/formateur': (context) => const FormateurDashboardPage(),
        '/apprenant': (context) => const ApprenantDashboardPage(),
        '/ressources': (context) => const RessourcesPage(),
        '/notifications': (context) => const NotificationsPage(),
        '/discussions': (context) => const DiscussionsPage(),
        '/logout': (context) => const DeconnexionPage(),
      },
    );
  }
}
