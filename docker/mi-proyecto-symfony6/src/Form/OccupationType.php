<?php

namespace App\Form;

use App\Entity\Occupation;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;
use Symfony\Component\Form\Extension\Core\Type\ChoiceType;
use Symfony\Component\Form\Extension\Core\Type\TextareaType;

class OccupationType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options): void
    {
        $builder
            ->add('type', ChoiceType::class, [
                'label' => 'Tipo de ocupación',
                'choices' => [
                    'WLF' => 'wlf',
                    'Serafitas' => 'seraphite',
                    'Nido de infectados' => 'infected_nest',
                ],
                'expanded' => true,
                'multiple' => false,
            ])
            ->add('wlfName', ChoiceType::class, [
                'label' => 'Miembro WLF',
                'choices' => [
                    'Abby' => 'Abby',
                    'Manny' => 'Manny',
                    'Nora' => 'Nora',
                    'Mel' => 'Mel',
                    'Owen' => 'Owen',
                    'Isaac' => 'Isaac',
                    'Jordan' => 'Jordan',
                    'Leah' => 'Leah',
                ],
                'placeholder' => 'Selecciona (solo WLF)',
                'required' => false,
            ])
            ->add('seraphiteWeapons', ChoiceType::class, [
                'label' => 'Armas (Serafitas)',
                'choices' => [
                    'Machete' => 'machete',
                    'Arco' => 'arco',
                    'Pistola' => 'pistola',
                ],
                'multiple' => true,
                'expanded' => true,
                'required' => false,
            ])
            ->add('infectedTypes', ChoiceType::class, [
                'label' => 'Tipos de infectados',
                'choices' => [
                    'Runners' => 'runner',
                    'Stalkers' => 'stalker',
                    'Clickers' => 'clicker',
                    'Bloaters' => 'bloater',
                    'Rat King' => 'rat_king',
                ],
                'multiple' => true,
                'expanded' => true,
                'required' => false,
            ])
            ->add('observation', TextareaType::class, [
                'label' => 'Observación',
                'required' => false,
                'attr' => ['rows' => 3],
            ]);
    }

    public function configureOptions(OptionsResolver $resolver): void
    {
        $resolver->setDefaults([
            'data_class' => Occupation::class,
        ]);
    }
}