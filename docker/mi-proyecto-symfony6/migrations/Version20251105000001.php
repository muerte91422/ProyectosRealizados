<?php

declare(strict_types=1);

namespace DoctrineMigrations;

use Doctrine\DBAL\Schema\Schema;
use Doctrine\Migrations\AbstractMigration;

final class Version20251105000001 extends AbstractMigration
{
    public function getDescription(): string
    {
        return 'Crear tablas post y occupation';
    }

    public function up(Schema $schema): void
    {
        $this->addSql('
            CREATE TABLE post (
                id INT AUTO_INCREMENT NOT NULL,
                number VARCHAR(10) NOT NULL UNIQUE,
                location VARCHAR(255) NOT NULL,
                PRIMARY KEY (id)
            ) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_unicode_ci` ENGINE = InnoDB
        ');

        $this->addSql('
            CREATE TABLE occupation (
                id INT AUTO_INCREMENT NOT NULL,
                post_id INT NOT NULL,
                type VARCHAR(50) NOT NULL,
                wlf_name VARCHAR(255) DEFAULT NULL,
                seraphite_weapons LONGTEXT DEFAULT NULL COMMENT "(DC2Type:simple_array)",
                infected_types LONGTEXT DEFAULT NULL COMMENT "(DC2Type:simple_array)",
                observation LONGTEXT DEFAULT NULL,
                PRIMARY KEY (id),
                FOREIGN KEY (post_id) REFERENCES post(id) ON DELETE CASCADE
            ) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_unicode_ci` ENGINE = InnoDB
        ');
    }

    public function down(Schema $schema): void
    {
        $this->addSql('DROP TABLE occupation');
        $this->addSql('DROP TABLE post');
    }
}