<?php

namespace App\Entity;

use App\Repository\PostRepository;
use Doctrine\Common\Collections\ArrayCollection;
use Doctrine\Common\Collections\Collection;
use Doctrine\ORM\Mapping as ORM;

#[ORM\Entity(repositoryClass: PostRepository::class)]
class Post
{
    #[ORM\Id]
    #[ORM\GeneratedValue]
    #[ORM\Column]
    private ?int $id = null;

    #[ORM\Column(length: 10, unique: true)]
    private ?string $number = null;

    #[ORM\Column(length: 255)]
    private ?string $location = null;

    #[ORM\OneToMany(mappedBy: 'post', targetEntity: Occupation::class, cascade: ['persist', 'remove'], orphanRemoval: true)]
    private Collection $occupations;

    public function __construct()
    {
        $this->occupations = new ArrayCollection();
    }

    public function getId(): ?int { return $this->id; }

    public function getNumber(): ?string { return $this->number; }
    public function setNumber(?string $number): self { $this->number = $number; return $this; }

    public function getLocation(): ?string { return $this->location; }
    public function setLocation(?string $location): self { $this->location = $location; return $this; }

    public function getOccupations(): Collection { return $this->occupations; }

    public function addOccupation(Occupation $occupation): self
    {
        if (!$this->occupations->contains($occupation)) {
            $this->occupations[] = $occupation;
            $occupation->setPost($this);
        }
        return $this;
    }

    public function removeOccupation(Occupation $occupation): self
    {
        if ($this->occupations->removeElement($occupation)) {
            if ($occupation->getPost() === $this) {
                $occupation->setPost(null);
            }
        }
        return $this;
    }
}