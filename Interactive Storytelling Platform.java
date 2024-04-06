@SpringBootApplication
public class StorytellingPlatform {
    public static void main(String[] args) {
        SpringApplication.run(StorytellingPlatform.class, args);
    }

    @RestController
    @RequestMapping("/stories")
    public class StoryController {
        private final StoryRepository storyRepository;
        private final ChoiceRepository choiceRepository;

        public StoryController(StoryRepository storyRepository, ChoiceRepository choiceRepository) {
            this.storyRepository = storyRepository;
            this.choiceRepository = choiceRepository;
        }

        @GetMapping("/{id}")
        public Story getStory(@PathVariable Long id) {
            Story story = storyRepository.findById(id).orElseThrow();
            List<Choice> choices = choiceRepository.findByStoryId(id);
            story.setChoices(choices);
            return story;
        }

        @PostMapping
        public Story createStory(@RequestBody Story story) {
            Story savedStory = storyRepository.save(story);
            return savedStory;
        }

        @PostMapping("/{storyId}/choices")
        public Choice createChoice(@PathVariable Long storyId, @RequestBody Choice choice) {
            choice.setStoryId(storyId);
            return choiceRepository.save(choice);
        }
    }

    @Entity
    public class Story {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String title;
        private String content;
        @Transient
        private List<Choice> choices;

        // Getters, setters, and other methods
    }

    @Entity
    public class Choice {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private Long storyId;
        private String text;
        private Long nextStoryId;

        // Getters, setters, and other methods
    }

    public interface StoryRepository extends JpaRepository<Story, Long> {
    }

    public interface ChoiceRepository extends JpaRepository<Choice, Long> {
        List<Choice> findByStoryId(Long storyId);
    }
}
