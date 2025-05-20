public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    private List<Category> categoryList;

    public CategoryAdapter(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtCategory;
        LinearLayout productContainer;

        public ViewHolder(View itemView) {
            super(itemView);
            txtCategory = itemView.findViewById(R.id.txtCategory);
            productContainer = itemView.findViewById(R.id.productContainer);
        }
    }

    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_category, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CategoryAdapter.ViewHolder holder, int position) {
        Category category = categoryList.get(position);
        holder.txtCategory.setText(category.name);

        holder.productContainer.removeAllViews();
        for (Product product : category.products) {
            TextView textView = new TextView(holder.itemView.getContext());
            textView.setText("- " + product.name);
            holder.productContainer.addView(textView);
        }
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }
}
