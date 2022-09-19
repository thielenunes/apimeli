package adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.meli.apimeli.R


class AdapterTest(

    private val myList: List<String>

): RecyclerView.Adapter<AdapterTest.MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int ) : MyViewHolder{
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.activity_item, parent, false)

        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int ) {
        val name = myList[position]
//        holder.textTittle.text = name

    }
    public fun interface onClick {
        fun activityClicked(activity: List<String>)
    }


    override fun getItemCount() = myList.size

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val textTittle: TextView = itemView.findViewById(R.id.text_title)



    }



}
