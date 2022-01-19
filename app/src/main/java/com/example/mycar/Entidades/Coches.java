package com.example.mycar.Entidades;

import java.util.List;

import javax.xml.namespace.QName;

public class Coches {

    String modelos;
    String version;
    String carroceria;
    String imagenes;
    String anio ;
    String puertas;
    String plazasHomologadas;
    String acabado;
    String pvp;
    String suspension_delantera;
    String suspension_trasera;
    String distancia_ejes;
    String velocidades;
    String traccion;
    String neumatico_delantero;
    String neumatico_trasero;
    String combustibles;
    String cambio_id;
    String cilindrada;
    String numeroCilindros;
    String diametro;
    String carrera;
    String posicionMotor;
    String orientacionMotor;
    String ratioComprension;
    String tipoAdmision;
    String numeroValvulas;
    String compresor;
    String intercooler;
    String potenciaMaxima;
    String rpmPotenciaMaxima;
    String parMaximo;
    String rpmAParMaximo;
    String emisiones,consumoUrbano,consumoExtraUrbano,consumoMedio,consumoDeposito,autonomiaAproximada,velocidad_maxima;

    public Coches(String modelos) {
        this.modelos = modelos;
    }

    public void setNumeroValvulas(String numeroValvulas) {
        this.numeroValvulas = numeroValvulas;
    }

    public String getEmisiones() {
        return emisiones;
    }

    public void setEmisiones(String emisiones) {
        this.emisiones = emisiones;
    }

    public String getConsumoUrbano() {
        return consumoUrbano;
    }

    public void setConsumoUrbano(String consumoUrbano) {
        this.consumoUrbano = consumoUrbano;
    }

    public String getConsumoExtraUrbano() {
        return consumoExtraUrbano;
    }

    public void setConsumoExtraUrbano(String consumoExtraUrbano) {
        this.consumoExtraUrbano = consumoExtraUrbano;
    }

    public String getConsumoMedio() {
        return consumoMedio;
    }

    public void setConsumoMedio(String consumoMedio) {
        this.consumoMedio = consumoMedio;
    }

    public String getConsumoDeposito() {
        return consumoDeposito;
    }

    public void setConsumoDeposito(String consumoDeposito) {
        this.consumoDeposito = consumoDeposito;
    }

    public String getAutonomiaAproximada() {
        return autonomiaAproximada;
    }

    public void setAutonomiaAproximada(String autonomiaAproximada) {
        this.autonomiaAproximada = autonomiaAproximada;
    }

    public String getVelocidad_maxima() {
        return velocidad_maxima;
    }

    public void setVelocidad_maxima(String velocidad_maxima) {
        this.velocidad_maxima = velocidad_maxima;
    }

    public String getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(String cilindrada) {
        this.cilindrada = cilindrada;
    }

    public String getNumeroCilindros() {
        return numeroCilindros;
    }

    public void setNumeroCilindros(String numeroCilindros) {
        this.numeroCilindros = numeroCilindros;
    }

    public String getDiametro() {
        return diametro;
    }

    public void setDiametro(String diametro) {
        this.diametro = diametro;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getPosicionMotor() {
        return posicionMotor;
    }

    public void setPosicionMotor(String posicionMotor) {
        this.posicionMotor = posicionMotor;
    }

    public String getOrientacionMotor() {
        return orientacionMotor;
    }

    public void setOrientacionMotor(String orientacionMotor) {
        this.orientacionMotor = orientacionMotor;
    }

    public String getRatioComprension() {
        return ratioComprension;
    }

    public void setRatioComprension(String ratioComprension) {
        this.ratioComprension = ratioComprension;
    }

    public String getTipoAdmision() {
        return tipoAdmision;
    }

    public void setTipoAdmision(String tipoAdmision) {
        this.tipoAdmision = tipoAdmision;
    }

    public String getNumeroValvulas() {
        return numeroValvulas;
    }

    public void setNumero_valvulas(String numero_valvulas) {
        this.numeroValvulas = numeroValvulas;
    }

    public String getCompresor() {
        return compresor;
    }

    public void setCompresor(String compresor) {
        this.compresor = compresor;
    }

    public String getIntercooler() {
        return intercooler;
    }

    public void setIntercooler(String intercooler) {
        this.intercooler = intercooler;
    }

    public String getPotenciaMaxima() {
        return potenciaMaxima;
    }

    public void setPotenciaMaxima(String potenciaMaxima) {
        this.potenciaMaxima = potenciaMaxima;
    }

    public String getRpmPotenciaMaxima() {
        return rpmPotenciaMaxima;
    }

    public void setRpmPotenciaMaxima(String rpmPotenciaMaxima) {
        this.rpmPotenciaMaxima = rpmPotenciaMaxima;
    }

    public String getParMaximo() {
        return parMaximo;
    }

    public void setParMaximo(String parMaximo) {
        this.parMaximo = parMaximo;
    }

    public String getRpmAParMaximo() {
        return rpmAParMaximo;
    }

    public void setRpmAParMaximo(String rmpAParMaximo) {
        this.rpmAParMaximo = rmpAParMaximo;
    }

    public String getCambio_id() {
        return cambio_id;
    }

    public void setCambio_id(String cambio_id) {
        this.cambio_id = cambio_id;
    }

    public Coches(String version, String modelos, String carroceria, String imagenes, String anio, String combustibles) {
        this.modelos = modelos;
        this.version = version;
        this.carroceria = carroceria;
        this.imagenes = imagenes;
        this.anio = anio;
        this.combustibles = combustibles;
    }

    public String getSuspension_delantera() {
        return suspension_delantera;
    }

    public void setSuspension_delantera(String suspension_delantera) {
        this.suspension_delantera = suspension_delantera;
    }

    public String getSuspension_trasera() {
        return suspension_trasera;
    }

    public void setSuspension_trasera(String suspension_trasera) {
        this.suspension_trasera = suspension_trasera;
    }

    public String getDistancia_ejes() {
        return distancia_ejes;
    }

    public void setDistancia_ejes(String distancia_ejes) {
        this.distancia_ejes = distancia_ejes;
    }

    public String getVelocidades() {
        return velocidades;
    }

    public void setVelocidades(String velocidades) {
        this.velocidades = velocidades;
    }

    public String getTraccion() {
        return traccion;
    }

    public void setTraccion(String traccion) {
        this.traccion = traccion;
    }

    public String getNeumatico_delantero() {
        return neumatico_delantero;
    }

    public void setNeumatico_delantero(String neumatico_delantero) {
        this.neumatico_delantero = neumatico_delantero;
    }

    public String getNeumatico_trasero() {
        return neumatico_trasero;
    }

    public void setNeumatico_trasero(String neumatico_trasero) {
        this.neumatico_trasero = neumatico_trasero;
    }


    public String getPlazasHomologadas() {
        return plazasHomologadas;
    }

    public void setPlazasHomologadas(String plazasHomologadas) {
        this.plazasHomologadas = plazasHomologadas;
    }

    public String getAcabado() {
        return acabado;
    }

    public void setAcabado(String acabado) {
        this.acabado = acabado;
    }

    public String getPvp() {
        return pvp;
    }

    public void setPvp(String pvp) {
        this.pvp = pvp;
    }



    public String getPuertas() {
        return puertas;
    }

    public void setPuertas(String puertas) {
        this.puertas = puertas;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getCombustibles() {
        return combustibles;
    }

    public void setCombustibles(String combustibles) {
        this.combustibles = combustibles;
    }



    public String getImagenes() {
        return imagenes;
    }

    public void setImagenes(String imagenes) {
        this.imagenes = imagenes;
    }

    public String getModelos() {
        return modelos;
    }

    public void setModelos(String modelos) {
        this.modelos = modelos;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCarroceria() {
        return carroceria;
    }

    public void setCarroceria(String carroceria) {
        this.carroceria = carroceria;
    }

    @Override
    public String toString() {
        return "Coches{" +
                "modelos='" + modelos + '\'' +
                ", version='" + version + '\'' +
                ", carroceria='" + carroceria + '\'' +
                ", imagenes='" + imagenes + '\'' +
                ", anio='" + anio + '\'' +
                ", puertas='" + puertas + '\'' +
                ", plazasHomologadas='" + plazasHomologadas + '\'' +
                ", acabado='" + acabado + '\'' +
                ", pvp='" + pvp + '\'' +
                ", suspension_delantera='" + suspension_delantera + '\'' +
                ", suspension_trasera='" + suspension_trasera + '\'' +
                ", distancia_ejes='" + distancia_ejes + '\'' +
                ", velocidades='" + velocidades + '\'' +
                ", traccion='" + traccion + '\'' +
                ", neumatico_delantero='" + neumatico_delantero + '\'' +
                ", neumatico_trasero='" + neumatico_trasero + '\'' +
                ", combustibles='" + combustibles + '\'' +
                ", cambio_id='" + cambio_id + '\'' +
                ", cilindrada='" + cilindrada + '\'' +
                ", numero_cilindros='" + numeroCilindros + '\'' +
                ", diametro='" + diametro + '\'' +
                ", carrera='" + carrera + '\'' +
                ", posicion_motor='" + posicionMotor + '\'' +
                ", orientacion_motor='" + orientacionMotor + '\'' +
                ", ratio_comprension='" + ratioComprension + '\'' +
                ", tipo_admision='" + tipoAdmision + '\'' +
                ", numero_valvulas='" + numeroValvulas + '\'' +
                ", compresor='" + compresor + '\'' +
                ", intercooler='" + intercooler + '\'' +
                ", potencia_maxima='" + potenciaMaxima + '\'' +
                ", rpm_potencia_max='" + rpmPotenciaMaxima + '\'' +
                ", par_maximo='" + parMaximo + '\'' +
                ", rpm_a_par_maximo='" + rpmAParMaximo + '\'' +
                '}';
    }
}
