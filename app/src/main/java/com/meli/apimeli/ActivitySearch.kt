package com.meli.apimeli

//import adapter.AdapterMock
import adapter.AdapterTest
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.meli.apimeli.databinding.ActivitySourceBinding


class ActivitySearch : AppCompatActivity() {

    private lateinit var binding: ActivitySourceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySourceBinding.inflate(layoutInflater)
        setContentView(binding.root)


//        //Layout da recycler
//        binding.recyclerViewList.layoutManager = LinearLayoutManager(baseContext)
//
//
//        //Evento de Enter no EditText
//        binding.inputTextSearch.setOnKeyListener { _, keyCode, keyEvent ->
//            if (keyEvent.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
//                if (binding.inputTextSearch.toString() ==  binding.inputTextSearch.toString()) {
//                    return@setOnKeyListener true
//                } else {
//                    Toast.makeText(this, "Digite um produto válido", Toast.LENGTH_LONG).show()
//                }
//
//            }
//            return@setOnKeyListener false
//        }

        initRecyclerView()

    }


    private fun initRecyclerView(){
        binding.recyclerViewList.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewList.setHasFixedSize(true)
        binding.recyclerViewList.adapter = AdapterTest(getList())
    }

    private fun getList() = listOf(
        "Teste",
        "Teste",
        "Teste",
        "Teste",
        "Teste"
    )

    /**
     * Obtenha os detalhes do produto por ID do item e converta o retorno da API em uma lista
     * */
//    private fun loadProducts(responseAPI: List<ItemProductResponse>?) {
//        //converter em lista de produtos
//        val products: MutableList<ItemAdapter.Product> = ArrayList()
//
//        if (responseAPI != null) {
//            //iterando a lista de resultados a partir da resposta da API
//            for (productAPI in responseAPI) {
//                val product = ItemAdapter.Product(
//                    productAPI.item.item_id,
//                    productAPI.item.item_title,
//                    productAPI.item.item_price, productAPI.item.item_thumbnail, ""
//                )
//                products.add(product)
//            }
//            binding.recyclerViewList.adapter = ItemAdapter(products) { product ->
//                onClickItem(
//                    product
//                )
//            }
//            binding.recyclerViewList.layoutManager = LinearLayoutManager(this)
//
//        }
//    }
//
//    private fun onClickItem(product: ItemAdapter.Product) {
//        val intent = Intent(this, ActivitySearch::class.java)
//        startActivity(intent)
//    }
//
//    /**
//     * Receba o ID do produto e obtenha os detalhes do tipo de item
//     * */
//    private fun getItemDetails(productIds: List<String>) {
//
//        val service = MeliApi.createCategoryService()
//        val ids = productIds.joinToString(",")
//
//        val call: Call<List<ItemProductResponse>> = service.itemList(ids)
//        call.enqueue(object : Callback<List<ItemProductResponse>> {
//            override fun onResponse(
//                call: Call<List<ItemProductResponse>>,
//                response: Response<List<ItemProductResponse>>
//            ) {
//                val productsAPI: List<ItemProductResponse>? = response.body()
//                loadProducts(productsAPI)
//            }
//
//            override fun onFailure(call: Call<List<ItemProductResponse>>, t: Throwable) {
//            }
//
//        })
//    }
//    /**
//     * Obtenha o ID da categoria para os produtos em destaque do Mercado Livre
//     * */
//    private fun getHighlightsByCategory(categoryId: String) {
//        val service = MeliApi.createCategoryService()
//
//        val callBestSeller: Call<HighlightsProductResponse> =
//            service.highlightsItemList(categoryId)
//
//        callBestSeller.enqueue(object :
//            Callback<HighlightsProductResponse> { //enqueue = colocar na fila
//            override fun onResponse(
//                call: Call<HighlightsProductResponse>,
//                response: Response<HighlightsProductResponse>
//            ) {
//                val highlightsProduct = response.body()
////                if (response.isSuccessful) {
////                    val productIds = highlightsProduct?.content?.stream()?.map { it.product_id }
////                        ?.collect(Collectors.toList())
////                    if (productIds != null) {
////                        getItemDetails(productIds)
////                    }
////                } else {
////                    messageErrorUser("Produto não encontrado.")
////                }
//
//            }
//
//            override fun onFailure(call: Call<HighlightsProductResponse>, t: Throwable) {
//                messageErrorUser("Produto não encontrado.")
//
//            }
//
//        })

//    }
//    /** o valor inserido na consulta apenas um item por categoria
//     * */
//    private fun getProductCategory(searchValue: String) {
//        //conectar o Retrofit e faz chamada assíncrona
//        val service = MeliApi.createCategoryService()
//
//        val call: Call<List<CategoryPredictorResponse>> = service.list(searchValue)
//        call.enqueue(object :
//            Callback<List<CategoryPredictorResponse>> { //enqueue = coloca na fila
//
//            override fun onResponse(
//                call: Call<List<CategoryPredictorResponse>>,
//                response: Response<List<CategoryPredictorResponse>>
//            ) {
//                if (response.isSuccessful) {
//                    val categories = response.body()
//                    if (categories?.isEmpty()!!) {
//                        messageErrorUser("Produto não encontrado. Verifique se a palavra está escrita corretamente.")
//                    } else {
//                        categories.get(0).let { getHighlightsByCategory(it.category_id) }
//                    }
//                } else {
//                    messageErrorUser("Erro interno no servidor.")
//                }
//
//            }
//
//            override fun onFailure(call: Call<List<CategoryPredictorResponse>>, t: Throwable) {
//                messageErrorUser("Verifique sua conexão de internet.")
//            }
//
//        })
//    }
//    private fun messageErrorUser(str: String) {
//        Toast.makeText(baseContext, str, Toast.LENGTH_LONG).show()
//    }
//
//    private fun cleanProductList() {
//        binding.recyclerViewList.adapter = ItemAdapter(arrayListOf()) {
//
//        }
//        binding.recyclerViewList.layoutManager = LinearLayoutManager(this)
//    }




}

