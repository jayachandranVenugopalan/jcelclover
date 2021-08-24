package com.jcel.jcelclover

import android.accounts.Account
import android.os.AsyncTask
import android.os.Bundle
import android.os.RemoteException
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController

import com.clover.sdk.util.CloverAccount
import com.clover.sdk.v1.BindingException
import com.clover.sdk.v1.ClientException
import com.clover.sdk.v1.ServiceException
import com.clover.sdk.v3.inventory.InventoryConnector
import com.clover.sdk.v3.inventory.Item
import com.clover.sdk.v3.order.OrderConnector
import java.util.*


class MainActivity :AppCompatActivity(){

    var mAccount: Account? = null
    private var mInventoryConnector: InventoryConnector? = null
    private var morderConnector: OrderConnector? = null
    private var mTextView: TextView? = null
    private var mcode: TextView? = null
    private var mprice: TextView? = null


    val EXTRA_DATA = "data"

    private val resultText: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupActionBarWithNavController(findNavController(R.id.navmain))
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController=findNavController(R.id.navmain)
        return navController.navigateUp()||super.onSupportNavigateUp()
    }
//    override fun onResume() {
//        super.onResume()
//        mTextView = findViewById<TextView>(R.id.userdata)
//        mcode=findViewById(R.id.codedata) as TextView
//        mprice=findViewById(R.id.pricedata) as TextView
//
//        // Retrieve the Clover account
//        if (mAccount == null) {
//            mAccount = CloverAccount.getAccount(this)
//            if (mAccount == null) {
//                return
//            }
//        }
//
//        // Connect InventoryConnector
//        connect()
//
//        // Get Item
//        InventoryAsyncTask().execute()
//    }
//
//    /*
//3) Disconnect from the Clover Connectors when you aren’t using them to
//   follow Android best practices and let the connection end naturally.
//*/
//    override fun onDestroy() {
//        super.onDestroy()
//        disconnect()
//    }
//
//    private fun connect() {
//        disconnect()
//        if (mAccount != null) {
//            mInventoryConnector = InventoryConnector(this, mAccount, null)
//            mInventoryConnector!!.connect()
//
//
//
//        }
//    }
//
//    private fun disconnect() {
//        if (mInventoryConnector != null) {
//            mInventoryConnector!!.disconnect()
//            mInventoryConnector = null
//        }
//
//    }
//
//    /*
//4) Use async tasks when working with Clover Connector classes to minimize
//   work on the main UI thread while fetching or changing data. See
//   https://docs.clover.com/clover-platform/docs/clover-development-
//   basics-android#section-async-tasks-and-executors.
//*/
//    private inner class InventoryAsyncTask :
//            AsyncTask<Void?, Void?, Item?>() {
//        override fun doInBackground(vararg params: Void?): Item? {
//            try {
//                //Get inventory item
//
//                Log.d("tag", "text ${  mInventoryConnector!!.itemsWithCategories}")
//                return mInventoryConnector!!.getItems().get(0)
////                mInventoryConnector!!.getItems().get(0)
//
//
//
//
//            } catch (e: RemoteException) {
//                e.printStackTrace()
//            } catch (e: ClientException) {
//                e.printStackTrace()
//            } catch (e: ServiceException) {
//                e.printStackTrace()
//            } catch (e: BindingException) {
//                e.printStackTrace()
//            }
//            return null
//        }
//
//
//
//
//        /*
//5) Set the TextView to display the item’s name. For other methods that Item
//   objects have, see
//   https://clover.github.io/clover-android-sdk/com/clover/sdk/v3/inventory
//   /Item.html
//*/
//        override fun onPostExecute(item: Item?) {
//            if (item != null) {
//
//
//                mTextView!!.setText(item.getName())
//                mcode!!.setText(item.code)
//                mprice!!.text=item.price.toString()
//
//                var name = arrayOf(item.name,item.name)
//                Log.d("tag", "text ${ Arrays.toString(name)}")
//            }
//        }
//
//
//    }



}


