package com.example.asm;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import android.os.Environment;
import android.widget.Toast;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostHoder> {

    private Activity activity;
    Context context;
    List<Item> postList;

    public  PostAdapter(Context context, List<Item> postList, Activity activity){
        this.context = context;
        this.postList =postList;
        this.activity = activity;
    }
    @NonNull
    @Override
    public PostHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(context).inflate(R.layout.eachpost , parent, false);
        return  new PostHoder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull PostHoder holder, int position) {

        Item item =postList.get(position);
        Picasso.get().load(item.getImage()).into(holder.imageView);
        holder.btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    saveImage(holder);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    private void saveImage(PostHoder holder) throws IOException {

        ActivityCompat.requestPermissions(activity,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
        FileOutputStream fileOutputStream =null;
        File file = getDisc();
        if(!file.exists()&& !file.mkdirs()){
            file.mkdirs();
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyymmsshhmmss");
        String date = simpleDateFormat.format(new Date());
        String name = "IMG" + date + ".jpg";
        String file_name = file.getAbsolutePath()+"/"+name;
        File new_file =new File(file_name);
        BitmapDrawable draw =(BitmapDrawable) holder.imageView.getDrawable();
        Bitmap bitmap=draw.getBitmap();
        fileOutputStream = new FileOutputStream(new_file);
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,fileOutputStream);
        Toast.makeText(context, "Save image success", Toast.LENGTH_SHORT).show();
        fileOutputStream.flush();
        fileOutputStream.close();


        refreshGallery(new_file);

    }
    private File getDisc(){
        File file = Environment.getExternalStorageDirectory();
        return new File(file,"FirebaseTutorial");
    }
    private  void refreshGallery(File file){
        Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        intent.setData(Uri.fromFile(file));
        context.sendBroadcast(intent);
    }
    @Override
    public int getItemCount() {
        return postList.size();
    }

    public class PostHoder extends RecyclerView.ViewHolder{


        ImageView imageView,btnDownload;


        public PostHoder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageview);
            btnDownload = (ImageView) itemView.findViewById(R.id.btnDownload);
        }
    }

}
