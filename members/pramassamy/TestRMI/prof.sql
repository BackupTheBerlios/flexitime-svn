# phpMyAdmin MySQL-Dump
# version 2.5.0-rc2
# http://www.phpmyadmin.net/ (download page)
#
# Serveur: localhost
# Généré le : Samedi 18 Décembre 2004 à 18:38
# Version du serveur: 4.0.21
# Version de PHP: 5.0.1
# Base de données: `hibernate`
# --------------------------------------------------------

#
# Structure de la table `prof`
#
# Création: Jeudi 16 Décembre 2004 à 00:55
# Dernière modification: Samedi 18 Décembre 2004 à 18:36
#

CREATE TABLE `prof` (
  `idProf` int(10) unsigned NOT NULL auto_increment,
  `nom` varchar(32) NOT NULL default '',
  `prenom` varchar(32) NOT NULL default '',
  `mail` varchar(64) NOT NULL default '',
  PRIMARY KEY  (`idProf`),
  UNIQUE KEY `nom` (`nom`)
) TYPE=MyISAM AUTO_INCREMENT=20 ;

#
# Contenu de la table `prof`
#

INSERT INTO `prof` (`idProf`, `nom`, `prenom`, `mail`) VALUES (1, 'Revuz', 'Dominique', 'dr@univ-mlv.fr'),
(2, 'Duris', 'Etienne', 'duris@univ-mlv.fr'),
(3, 'Forax', 'Rémi', 'forax@univ-mlv.fr'),
(16, 'Ping', 'ldkf', 'lksdf'),
(9, 'Ramassamy', 'prâsad', 'prasadrama@free.fr'),
(15, 'Grebert', 'tata', 'titi'),
(17, 'calmejane', 'zlkdsjzl', 'zlkdlkd'),
(18, 'Midonnet', 'Serge', 's.midonnet@univ-mlv.fr'),
(19, 'Roussel', 'Gilles', 'roussel@univ-mlv.fr');

