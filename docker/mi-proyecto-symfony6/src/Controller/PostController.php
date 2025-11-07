<?php

namespace App\Controller;

use App\Entity\Post;
use App\Form\PostOccupationType;
use App\Repository\PostRepository;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Component\HttpFoundation\HeaderUtils;

#[Route('/posts')]
class PostController extends AbstractController
{
    #[Route('/', name: 'app_post_index', methods: ['GET'])]
    public function index(PostRepository $postRepository): Response
    {
        return $this->render('post/index.html.twig', [
            'posts' => $postRepository->findAll(),
        ]);
    }

    #[Route('/new', name: 'app_post_new', methods: ['GET', 'POST'])]
    public function new(Request $request, EntityManagerInterface $em): Response
    {
        $post = new Post();
        $form = $this->createForm(PostOccupationType::class, $post);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $em->persist($post);
            $em->flush();
            return $this->redirectToRoute('app_post_index');
        }

        return $this->render('post/new.html.twig', [
            'form' => $form->createView(),
        ]);
    }

    #[Route('/export', name: 'app_post_export', methods: ['GET'])]
    public function export(EntityManagerInterface $em): Response
    {
        $sql = "SELECT * FROM v_occupation_consolidated";
        $stmt = $em->getConnection()->prepare($sql);
        $result = $stmt->executeQuery();
        $data = $result->fetchAllAssociative();

        $headers = [
            'post_number' => 'Número del puesto',
            'location' => 'Localización',
            'occupation_type' => 'Tipo de ocupación',
            'wlf_name' => 'Nombre',
            'seraphite_weapons' => 'Armas',
            'infected_types' => 'Tipo de zombie',
            'observation' => 'Observación'
        ];

        $csv = implode(',', array_values($headers)) . "\n";

        foreach ($data as $row) {
            $line = [];
            foreach ($headers as $key => $label) {
                $value = $row[$key] ?? '';
                if (is_array($value)) {
                    $value = implode(', ', $value);
                }
                $line[] = '"' . str_replace('"', '""', $value) . '"';
            }
            $csv .= implode(',', $line) . "\n";
        }

        $response = new Response($csv);
        $response->headers->set('Content-Type', 'text/csv; charset=UTF-8');
        $response->headers->set('Content-Disposition', 'attachment; filename="threat_map.csv"');
        return $response;
    }
}