package com.example.serverandroid.AllViewPager;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.serverandroid.Model.ProductsModel;
import com.example.serverandroid.R;

import java.util.List;

public class ViewPagerproduct extends RecyclerView.Adapter<ViewPagerproduct.ViewhodelPro> {
    private List<ProductsModel> productsModels;
    private Context mContext;

    public ViewPagerproduct(List<ProductsModel> productsModels, Context mContext) {
        this.productsModels = productsModels;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewhodelPro onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(mContext).inflate(R.layout.layout_item,parent,false);
        return new ViewhodelPro(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewhodelPro holder, int position) {
        ProductsModel productsModel=productsModels.get(position);
        if (productsModel!=null){
            holder.tvName.setText(productsModel.getName());
            holder.tvPrice.setText(String.valueOf(productsModel.getPrice()));
            Glide.with(mContext).load("http://10.0.2.2:3000"+productsModel.getImage()).error(R.drawable.ic_action_name1).into(holder.img1);
            holder.id_Detail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Dialog dialog=new Dialog(mContext);
                    dialog.setContentView(R.layout.detail_pro);
                    Window window= dialog.getWindow();
                    ImageView img=dialog.findViewById(R.id.detailImg);
                    TextView tvnameDetail=dialog.findViewById(R.id.id_nameDetail);
                    TextView tvDes=dialog.findViewById(R.id.id_DescriptionDetail);
                    TextView tvprice=dialog.findViewById(R.id.id_PriceDetail);
                    TextView cate=dialog.findViewById(R.id.id_nameCategoryDetail);
                    tvnameDetail.setText(productsModel.getName());
                    tvprice.setText(String.valueOf(productsModel.getPrice()));
                    tvDes.setText(productsModel.getDescription());
                    cate.setText(productsModel.getId_Category().getName());
                    Glide.with(mContext).load("http://10.0.2.2:3000"+productsModel.getImage()).error(R.drawable.ic_action_name1).into(img);
                    window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                    dialog.show();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return productsModels.size();
    }

    public class ViewhodelPro extends RecyclerView.ViewHolder {
        ImageView img1;
        LinearLayout id_Detail;
        TextView tvName,tvPrice;
        public ViewhodelPro(@NonNull View itemView) {
            super(itemView);
            img1=itemView.findViewById(R.id.imagev);
            tvName=itemView.findViewById(R.id.id_name);
            tvPrice=itemView.findViewById(R.id.id_Price);
            id_Detail=itemView.findViewById(R.id.id_Detail);

        }
    }
}
