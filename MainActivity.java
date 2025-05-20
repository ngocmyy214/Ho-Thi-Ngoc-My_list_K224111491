public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    CategoryAdapter categoryAdapter;
    List<Category> categoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        categoryList = getSampleData();
        categoryAdapter = new CategoryAdapter(categoryList);
        recyclerView.setAdapter(categoryAdapter);
    }

    private List<Category> getSampleData() {
        List<Category> categories = new ArrayList<>();

        List<Product> fruits = Arrays.asList(
            new Product("Apple"),
            new Product("Banana"),
            new Product("Mango")
        );

        List<Product> electronics = Arrays.asList(
            new Product("Laptop"),
            new Product("Phone"),
            new Product("Tablet")
        );

        categories.add(new Category("Fruits", fruits));
        categories.add(new Category("Electronics", electronics));

        return categories;
    }
}
