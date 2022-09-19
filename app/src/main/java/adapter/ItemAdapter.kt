package adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.meli.apimeli.R


//biblioteca para carregar Imagem, precisou importar no build grandle
import com.squareup.picasso.Picasso

class ItemAdapter(
    private val products: MutableList<Product>,
    private val onClickItem: (Product) -> Unit
) :
    RecyclerView.Adapter<ItemAdapter.ProductViewHolder>() {


    //cria as visualizações da lista
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val list = LayoutInflater.from(parent.context).inflate(R.layout.activity_item, parent, false)
        return ProductViewHolder(list, onClickItem)
    }

    //exibe as visualizações pro usuário
    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(products[position])
    }

    //contagem do tamanho
    override fun getItemCount(): Int {
        return products.size
    }

    // passando uma posicao ref ao item que vai ser clicado quando o cliente clicar para ver o item
    inner class ProductViewHolder(itemView: View, private val onClickItem: (Product) -> Unit) :
        RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener {
                onClickItem(products[absoluteAdapterPosition])
            }
        }
// chama cada parte que foi setada no layout
        fun bind(product: Product) {
            val txtName: TextView = itemView.findViewById(R.id.text_title)
            val txtPrice: TextView = itemView.findViewById(R.id.text_price)
            val imgProduct: ImageView = itemView.findViewById(R.id.image_item)
            txtName.text = product.product_name
            txtPrice.text = "R$ " + product.product_price.toString()
            Picasso.get().load(product.product_image).into(imgProduct)

        }
    }

    //data class do produto, para definir valor dos produtos
    data class Product(
        var product_id: String,
        val product_name: String,
        val product_price: Float,
        val product_image: String,
        var product_description: String,

        )}