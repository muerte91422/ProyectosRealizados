<?php

namespace App\Entity;

use App\Repository\OccupationRepository;
use Doctrine\ORM\Mapping as ORM;

#[ORM\Entity(repositoryClass: OccupationRepository::class)]
class Occupation
{
    #[ORM\Id]
    #[ORM\GeneratedValue]
    #[ORM\Column]
    private ?int $id = null;

    #[ORM\Column(length: 50)]
    private ?string $type = null;

    #[ORM\Column(length: 255, nullable: true)]
    private ?string $wlfName = null;

    #[ORM\Column(type: 'simple_array', nullable: true)]
    private array $seraphiteWeapons = [];

    #[ORM\Column(type: 'simple_array', nullable: true)]
    private array $infectedTypes = [];

    #[ORM\Column(type: 'text', nullable: true)]
    private ?string $observation = null;

    #[ORM\ManyToOne(targetEntity: Post::class, inversedBy: 'occupations')]
    #[ORM\JoinColumn(nullable: false)]
    private ?Post $post = null;

    public function getId(): ?int { return $this->id; }

    public function getType(): ?string { return $this->type; }
    public function setType(?string $type): self { $this->type = $type; return $this; }

    public function getWlfName(): ?string { return $this->wlfName; }
    public function setWlfName(?string $wlfName): self { $this->wlfName = $wlfName; return $this; }

    public function getSeraphiteWeapons(): array { return $this->seraphiteWeapons; }
    public function setSeraphiteWeapons(?array $seraphiteWeapons): self { $this->seraphiteWeapons = $seraphiteWeapons ?? []; return $this; }

    public function getInfectedTypes(): array { return $this->infectedTypes; }
    public function setInfectedTypes(?array $infectedTypes): self { $this->infectedTypes = $infectedTypes ?? []; return $this; }

    public function getObservation(): ?string { return $this->observation; }
    public function setObservation(?string $observation): self { $this->observation = $observation; return $this; }

    public function getPost(): ?Post { return $this->post; }
    public function setPost(?Post $post): self { $this->post = $post; return $this; }
}