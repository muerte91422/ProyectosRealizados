<?php

declare(strict_types=1);

namespace DoctrineMigrations;

use Doctrine\DBAL\Schema\Schema;
use Doctrine\Migrations\AbstractMigration;

final class Version20251105000002 extends AbstractMigration
{
    public function getDescription(): string
    {
        return 'Crear vista v_occupation_consolidated';
    }

    public function up(Schema $schema): void
    {
        $this->addSql('
            CREATE OR REPLACE VIEW v_occupation_consolidated AS
            SELECT 
                p.number AS post_number,
                p.location AS location,
                o.type AS occupation_type,
                o.wlf_name AS wlf_name,
                o.seraphite_weapons AS seraphite_weapons,
                o.infected_types AS infected_types,
                o.observation AS observation
            FROM post p
            LEFT JOIN occupation o ON p.id = o.post_id
            ORDER BY p.number, o.type
        ');
    }

    public function down(Schema $schema): void
    {
        $this->addSql('DROP VIEW IF EXISTS v_occupation_consolidated');
    }
}