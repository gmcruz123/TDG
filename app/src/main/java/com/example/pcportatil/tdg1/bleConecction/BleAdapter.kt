
package com.example.pcportatil.tdg1.bleConecction
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.pcportatil.tdg1.databinding.TemplatedevicesBinding

/**
 * Created by PC portatil on 25/01/2018.
 */

class `BleAdapter` : RecyclerView.Adapter<BleHolder>(){
    override fun onBindViewHolder(holder: BleHolder?, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateViewHolder(parent: android.view.ViewGroup?, viewType: Int): BleHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}



class BleHolder(view: View):RecyclerView.ViewHolder(view) {
val binding : TemplatedevicesBinding = DataBindingUtil.bind(view)
}

