package com.jcel.jcelclover.ui

import android.accounts.Account
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.clover.connector.sdk.v3.PaymentConnector
import com.clover.sdk.util.CloverAccount
import com.clover.sdk.v3.connector.ExternalIdUtils
import com.clover.sdk.v3.connector.IPaymentConnectorListener
import com.clover.sdk.v3.remotepay.*
import com.jcel.jcelclover.R


class InvoiceFragment : Fragment(){




    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_invoice, container, false)
        // Initialize the PaymentConnector with a listener

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // Initialize the PaymentConnector with a listener
        val paymentConnector:PaymentConnector?  = initializePaymentConnector();

        var  saleButton = view.findViewById<Button>(R.id.pay1)
        saleButton.setOnClickListener() {

             var saleRequest:SaleRequest? = setupSaleRequest()
            paymentConnector?.sale(saleRequest)
        }
    }
    private fun initializePaymentConnector(): PaymentConnector? {
        // Get the Clover account that will be used with the service; uses the GET_ACCOUNTS permission
        val mAccount: Account = CloverAccount.getAccount(activity)
        // Set your RAID as the remoteApplicationId
        val remoteApplicationId = "JMB8M5B10P6N6.H1WDYW0SF8ZVA"

        //Implement the interface
        val paymentConnectorListener: IPaymentConnectorListener = object : IPaymentConnectorListener {
            override fun onDeviceDisconnected() {
            }

            override fun onDeviceConnected() {
            }

            override fun onPreAuthResponse(response: PreAuthResponse?) {
            }

            override fun onAuthResponse(response: AuthResponse?) {
            }

            override fun onTipAdjustAuthResponse(response: TipAdjustAuthResponse?) {
            }

            override fun onCapturePreAuthResponse(response: CapturePreAuthResponse?) {
            }

            override fun onVerifySignatureRequest(request: VerifySignatureRequest?) {
            }

            override fun onConfirmPaymentRequest(request: ConfirmPaymentRequest?) {
            }

            override fun onSaleResponse(response: SaleResponse) {
                val result: String
                result = if (response.success) {
                    "Sale was successful"
                } else {
                    "Sale was unsuccessful" + response.reason + ":" + response.message
                }
                Toast.makeText(activity?.getApplication()?.getApplicationContext(), result, Toast.LENGTH_LONG).show()
            }

            override fun onManualRefundResponse(response: ManualRefundResponse?) {
                TODO("Not yet implemented")
            }

            override fun onRefundPaymentResponse(response: RefundPaymentResponse?) {
                TODO("Not yet implemented")
            }

            override fun onTipAdded(tipAdded: TipAdded?) {
                TODO("Not yet implemented")
            }

            override fun onVoidPaymentResponse(response: VoidPaymentResponse?) {
                TODO("Not yet implemented")
            }

            override fun onVaultCardResponse(response: VaultCardResponse?) {
            }

            override fun onRetrievePendingPaymentsResponse(retrievePendingPaymentResponse: RetrievePendingPaymentsResponse?) {
           }

            override fun onReadCardDataResponse(response: ReadCardDataResponse?) {
            }

            override fun onCloseoutResponse(response: CloseoutResponse?) {
            }

            override fun onRetrievePaymentResponse(response: RetrievePaymentResponse?) {
            }

            override fun onVoidPaymentRefundResponse(response: VoidPaymentRefundResponse?) {
            }
        }

        // Implement the other IPaymentConnector listener methods

        // Create the PaymentConnector with the context, account, listener, and RAID
        return PaymentConnector(activity, mAccount, paymentConnectorListener, remoteApplicationId)
    }
    private fun setupSaleRequest(): SaleRequest? {
        // Create a new SaleRequest and populate the required request fields
        val saleRequest = SaleRequest()
        saleRequest.externalId = ExternalIdUtils.generateNewID()
        //required, but can be any string
        saleRequest.amount = 1000L
        return saleRequest
    }
}







