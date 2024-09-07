import 'package:flutter/material.dart';

class NotificationsPage extends StatefulWidget {
  final String? payload;

  const NotificationsPage({super.key, this.payload});

  @override
  State<NotificationsPage> createState() => _NotificationsPageState();
}

class _NotificationsPageState extends State<NotificationsPage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
       appBar: AppBar(
        backgroundColor: Colors.blue,
        title: const Text('Dashboard', textAlign: TextAlign.center),
      ),
      body: Center(
        child: Text('Détails de la notification: ${widget.payload}'),
      ),
    );
  }
}
