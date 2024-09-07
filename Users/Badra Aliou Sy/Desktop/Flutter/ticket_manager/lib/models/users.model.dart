import 'package:flutter/material.dart';

enum RoleUser{ Admin, Formateur, Apprenant}

class UserModel {
  final String id;
  final String email;
  final String password;
  final String nom;
  final String prenom;
  final String telephone;
  final RoleUser role;

  UserModel({
    required this.id,
    required this.email,
    required this.password,
    required this.role,
    required this.nom,
    required this.prenom,
    required this.telephone,


  });

  factory UserModel.fromMap(Map<String, dynamic> data) {
    return UserModel(
      id: data['id'],
      email: data['email'],
      password: data['password'],
      nom: data['nom'],
      prenom: data['prenom'],
      telephone: data['telephone'],
      role: RoleUser.values.firstWhere((e) => e.toString() == data['role']),
    );
  }

  Map<String, dynamic> toMap() {
    return {
      'id': id,
      'email': email,
      'password': password,
      'nom': nom,
      'prenom': prenom,
      'telephone': telephone,
      'role': role.toString(),
    };
  }
}
