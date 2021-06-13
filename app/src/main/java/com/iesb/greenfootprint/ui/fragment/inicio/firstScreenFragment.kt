package com.iesb.greenfootprint.ui.fragment.inicio

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.iesb.greenfootprint.R
import com.iesb.greenfootprint.databinding.FragmentSplashScreenBinding

class firstScreenFragment : Fragment() , OnMapReadyCallback {

    private lateinit var screenBinding: FragmentSplashScreenBinding
    private lateinit var map: GoogleMap


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        screenBinding = FragmentSplashScreenBinding.inflate(inflater, container, false)
        screenBinding.lifecycleOwner = this

        //fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        return screenBinding.root
    }


    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap

        val bsbPosition = LatLng(-15.7601 ,-47.9292)
        val CityParkPosition = LatLng(-15.793514, -47.899332)
        val CPposition = MarkerOptions().position(CityParkPosition).title("Parque da Cidade")
        map.addMarker(CPposition)
        val EyesPosition = LatLng(-15.745018, -47.884425)
        val Eyesposition = MarkerOptions().position(EyesPosition).title("Parque Olhos d´Água")
        map.addMarker(Eyesposition)
        val ParkNacionalPosition = LatLng( -15.729318, -47.925701 )
        val PNposition = MarkerOptions().position(ParkNacionalPosition).title("Parque Nacional de Brasília")
        map.addMarker(PNposition)
        val ContagemPosition = LatLng( -15.673810, -47.867341 )
        val Contposition = MarkerOptions().position(ContagemPosition).title("Reserva de Contagem")
        map.addMarker(Contposition)
        val EstEcoAguaEmenPosition = LatLng(-15.556359, -47.603833)
        val EEAEposition = MarkerOptions().position(EstEcoAguaEmenPosition).title("Estação Ecológica de Águas Emendadas")
        map.addMarker(EEAEposition)
        val RIBGEPosition = LatLng(-15.918702, -47.873812)
        val Aibgeposition = MarkerOptions().position(RIBGEPosition).title("Reserva Ecológica IBGE")
        map.addMarker(Aibgeposition)
        val PEACPosition = LatLng( -15.834838, -48.024001)
        val peacposition = MarkerOptions().position(PEACPosition).title("Parque Ecológico de Águas Claras")
        map.addMarker(peacposition)
        val REPosition = LatLng( -15.955915, -47.984693)
        val reposition = MarkerOptions().position(REPosition).title("Reserva Ecológica")
        map.addMarker(reposition)
        val PETPosition = LatLng( -15.847082, -47.929523)
        val petposition = MarkerOptions().position(PETPosition).title("Parque Ecológico Telebrasília")
        map.addMarker(petposition)
        val RPAPLPosition = LatLng( -15.732412, -47.925939)
        val rpaplposition = MarkerOptions().position(RPAPLPosition).title("Reserva de proteção ambiental do Planalto Central")
        map.addMarker(rpaplposition)
        val PEGEHPosition = LatLng( -15.833883, -47.967717)
        val pegehplposition = MarkerOptions().position(PEGEHPosition).title("Parque Ecológico do Guará Ezechias Heringer")
        map.addMarker(pegehplposition)


        map.moveCamera(CameraUpdateFactory.newLatLngZoom(bsbPosition, 10f))
    }
}


