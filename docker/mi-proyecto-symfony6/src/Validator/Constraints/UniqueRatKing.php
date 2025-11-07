<?php

namespace App\Validator\Constraints;

use Symfony\Component\Validator\Constraint;

#[\Attribute(\Attribute::TARGET_PROPERTY)]
class UniqueRatKing extends Constraint
{
    public string $message = 'Only one Rat King is allowed in the entire city.';
    
    public function getTargets(): string
    {
        return self::PROPERTY_CONSTRAINT;
    }
}