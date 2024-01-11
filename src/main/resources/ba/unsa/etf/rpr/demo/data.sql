DROP TABLE IF EXISTS `drzava`;
CREATE TABLE IF NOT EXISTS `drzava` (
  `id` int NOT NULL,
  `naziv` text NOT NULL,
  `glavni_grad` int NOT NULL);


DROP TABLE IF EXISTS `grad`;
CREATE TABLE IF NOT EXISTS `grad` (
  `id` int NOT NULL,
  `naziv` text NOT NULL,
  `broj_stanovnika` int NOT NULL,
  `drzava` int NOT NULL);


