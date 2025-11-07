<?php

namespace App\Validator\Constraints;

use App\Entity\Occupation;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Component\Validator\Constraint;
use Symfony\Component\Validator\ConstraintValidator;
use Symfony\Component\Validator\Exception\UnexpectedTypeException;

class UniqueRatKingValidator extends ConstraintValidator
{
    public function __construct(
        private EntityManagerInterface $entityManager
    ) {}

    public function validate($value, Constraint $constraint): void
    {
        
        if (!$constraint instanceof UniqueRatKing) {
            throw new UnexpectedTypeException($constraint, UniqueRatKing::class);
        }

        if (!$value instanceof Occupation) {
            return;
        }

        
        $infectedTypes = $value->getInfectedTypes() ?? [];
        if (!in_array('rat_king', $infectedTypes)) {
            return; 
        }

        
        $existing = $this->entityManager->getRepository(Occupation::class)
            ->createQueryBuilder('o')
            ->where(':type MEMBER OF o.infectedTypes')
            ->setParameter('type', 'rat_king')
            ->getQuery()
            ->getResult();

        
        $currentId = $value->getId();
        foreach ($existing as $occ) {
            if ($occ->getId() !== $currentId) {
                $this->context->buildViolation($constraint->message)
                    ->atPath('infectedTypes')
                    ->addViolation();
                return;
            }
        }
    }
}