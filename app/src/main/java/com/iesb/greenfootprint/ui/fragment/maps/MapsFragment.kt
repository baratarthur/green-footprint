package com.iesb.greenfootprint.ui.fragment.maps

import android.location.Location
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.iesb.greenfootprint.R
import com.iesb.greenfootprint.databinding.FragmentMapsBinding
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class MapsFragment : Fragment() , OnMapReadyCallback {

    private lateinit var mapsbinding: FragmentMapsBinding
    private lateinit var map: GoogleMap
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    //private lateinit var locationManager: LocationManager
    //private val listaPontos = mutableListOf<LatLng>()
    //private val MAP_REQUEST_TICKET = 888


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mapsbinding = FragmentMapsBinding.inflate(inflater, container, false)
        mapsbinding.lifecycleOwner = this

        //fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        return mapsbinding.root
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap

        val myPosition = LatLng(-15.793514, -47.899332)
        val position = MarkerOptions().position(myPosition).title("Eu")

        map.addMarker(position)
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(myPosition, 16f))
    }

/*
    private fun checkPermission() {
        if (ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                MAP_REQUEST_TICKET
            )
        } else {
            setupLocation()
        }
    }

*/
/*
    private fun setupLocation() {
        if (ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }
    }

 */

/*
   override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == MAP_REQUEST_TICKET) { // VERIFICA SE A RESPOSTA É PARA A SOLICITAÇÃO DO MAPA
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                setupLocation()
            } else {
               // showSnackbar("A permissão de localização é obrigatória!") {
                  //  checkPermission()
                }
            }
        }

*/

}
