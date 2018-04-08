package es.unileon.prg1.date;

public class Date {
	private int day;
	private int month;
	private int year;

	public Date(){
		this.year = 2018;
		this.month = 0;
		this.day = 0;
	}
		
	public Date(int day, int month, int year) throws DateException{
		this.year = year;
		if (month < 1 || month > 12) {
			throw new DateException("Mes " + month + " no valido" +
					" Valores posibles entre 1 y 12.");
		} else {
			this.month = month;
		}
		switch(month){
			case 1: //next
			case 3: //next
			case 5: //next
			case 7: //next
			case 8: //next
			case 10: //next
			case 12:
				if((day>=1) && (day<=31)){
					this.day = day;	
				} else {
					throw new DateException("Dia " + day + " no valido para el mes " + month + ", valores posibles entre 1 y 31.");
				}
				break;
			case 4: //next
			case 6: //next
			case 9: //next
			case 11:
				if((day>=1) && (day<=30)){
					this.day = day;	
				} else {
					throw new DateException("Dia " + day + " no valido para el mes " + month + ", valores posibles entre 1 y 30.");
				}
				break;
			case 2:
				if((day>=1) && (day<=28)){
					this.day = day;
				} else {
					throw new DateException("Dia " + day + " no valido para el mes " + month + ", valores posibles entre 1 y 28.");
				}
				break;
		}
	}

	public Date(Date fecha){
		this.day = fecha.getDay();
		this.month = fecha.getMonth();
		this.year = fecha.getYear();
	}

	@Override
	public String toString() {
		return this.day + "/" + this.month + "/" + this.year;
	}	

	public int getDay(){
		return this.day;
	}

	public int getMonth(){
		return this.month;
	}
	
	public int getYear(){
		return this.year;
	}

	void setDay(int nuevoDay){
		this.day = nuevoDay;	
	}

	void setMonth(int nuevoMonth){
		this.month = nuevoMonth;
	}
	
	void setYear(int nuevoYear){
		this.year = nuevoYear;
	}

	public boolean isSameDayIf(Date another){
		if ( this.day == another.getDay() ){
			return true;
		}
		return false;
	}
	
	public boolean isSameMonthIf(Date another){
		if ( this.month == another.getMonth() ){
			return true;
		}
		return false;
	}

	public boolean isSameYearIf(Date another){
		if ( this.year == another.getYear() ){
			return true;
		}
		return false;
	}

	public boolean isSameIf(Date another){
		if (isSameDayIf(another) && isSameMonthIf(another)  && isSameYearIf(another)){
			return true;
		}
		return false;
	}

	public boolean isSameDay(Date another){
		return another.day == this.day;
	}
	
	public boolean isSameMonth(Date another){
		return another.month == this.month;
	}

	public boolean isSameYear(Date another){
		return another.year == this.year;
	}

	public boolean isSame(Date another){
		return isSameDay(another) && isSameMonth(another)  && isSameYear(another);
	}

	public String getMonthName(){
		String name = " ";
		switch(this.month){
			case 1:
				name = "Enero";
				break;
			case 2:
				name = "Febrero";
				break;
			case 3:
				name = "Marzo";
				break;
			case 4:
				name = "Abril";
				break;
			case 5:
				name = "Mayo";
				break;
			case 6:
				name = "Junio";
				break;
			case 7:
				name = "Julio";
				break;
			case 8:
				name = "Agosto";
				break;
			case 9:
				name = "Septiembre";
				break;
			case 10:
				name = "Octubre";
				break;
			case 11:
				name = "Noviembre";
				break;
			case 12:
				name = "Diciembre";
				break;
		}
		return name;
	}

	boolean isDayRight(int day){
		boolean iDR = false;
		switch(this.month){
			case 1: //next
			case 3: //next
			case 5: //next
			case 7: //next
			case 8: //next
			case 10: //next
			case 12:
				iDR = ((day>=1) && (day<=31));
				break;
			case 4: //next
			case 6: //next
			case 9: //next
			case 11:
				iDR = ((day>=1) && (day<=30));
				break;
			case 2:
				iDR = ((day>=1) && (day<=28));
				break;
		}
		return iDR;
	}

	public String getSeasonName(){
		String n = " ";
		switch(this.month){
			case 1: //next
			case 2:
				n="Invierno";
				break;
			case 3:
				if(this.day<21){
					n="Invierno";
				} else {
					n="Primavera";
				}
				break;
			case 4: //next
			case 5: 
				n="Primavera";
				break;
			case 6:
				if(this.day<21){
					n="Primavera";
				} else {
					n="Verano";
				}
				break;
			case 7: //next
			case 8: 
				n="Verano";
				break;
			case 9:
				if(this.day<23){
					n="Verano";
				} else {
					n="Otoño";
				}
				break;
			case 10: //next
			case 11:				
				n="Otoño";
				break;
			case 12:
				if(this.day<21){
					n="Otoño";
				} else {
					n="Invierno";
				}
				break;
		}
		return n;
	}

	public String getMonthsLeft(){
		StringBuilder months;
		int month;
		months = new StringBuilder();
		month = this.month;
		for (int i = this.month;i<12;i++){
			this.month=this.month+1;
			months.append(this.getMonthName() + " ");
		}
		this.month=month; //Como en el bucle for se modifica el valor de this.month previamente guarde el valor original para volver a ponerlo ahora
		return months.toString();
	}

	public String getDaysLeftOfMonth(){
		StringBuilder restantes;
		int dia=this.day;
		restantes = new StringBuilder();
		dia=this.day;
		while(this.isDayRight(++this.day)==true){
			restantes.append(this.toString() + " ");
		}
		this.day=dia; //Como en el bucle while se modifica el valor de this.dia previamente guarde el valor original para volver a ponerlo ahora
		return restantes.toString();
	}

	public String getMonthsSameDays(){
		String mismosDias = " ";
		switch(this.month){
			case 1:
				mismosDias = "Marzo Mayo Julio Agosto Octubre Diciembre";
				break;
			case 2:
				mismosDias = " ";
				break;
			case 3:
				mismosDias = "Enero Mayo Julio Agosto Octubre Diciembre";
				break;
			case 4:
				mismosDias = "Junio Septiembre Noviembre";
				break;
			case 5:
				mismosDias = "Enero Marzo Julio Agosto Octubre Diciembre";
				break;
			case 6:
				mismosDias = "Abril Septiembre Noviembre";
				break;
			case 7:
				mismosDias = "Enero Marzo Mayo Agosto Octubre Diciembre";
				break;
			case 8:
				mismosDias = "Enero Marzo Mayo Julio Octubre Diciembre";
				break;
			case 9:
				mismosDias = "Abril Junio Noviembre";
				break;
			case 10:
				mismosDias = "Enero Marzo Mayo Julio Agosto Diciembre";
				break;
			case 11:
				mismosDias = "Abril Junio Septiembre";
				break;
			case 12:
				mismosDias = "Enero Marzo Mayo Julio Agosto Octubre";
				break;
		}
		return mismosDias;
	}
			
	public int daysPast(){
		int total=0;
		switch(this.month){
			case 1:
				total = this.day;
				break;
			case 2:
				total = this.day+31;
				break;
			case 3:
				total = this.day+31+28;
				break;
			case 4:
				total = this.day+2*31+28;
				break;
			case 5:
				total = this.day+2*31+28+30;
				break;
			case 6:
				total = this.day+3*31+28+30;
				break;
			case 7:
				total = this.day+3*31+28+2*30;
				break;
			case 8:
				total = this.day+4*31+28+2*30;
				break;
			case 9:
				total = this.day+5*31+28+2*30;
				break;
			case 10:
				total = this.day+5*31+28+3*30;
				break;
			case 11:
				total = this.day+6*31+28+3*30;
				break;
			case 12:
				total = this.day+6*31+28+4*30;
				break;
		}
		return total;
	}

	public int numRandomTriesEqualDate1(){
		int contador, dia, mes;
		contador = 0;
		dia = 0;
		mes = 0;
		while(dia!=this.day || mes!=this.month){
			mes = (int)(Math.random()*12+1);
			switch(mes){
				case 1: //next
				case 3: //next
				case 5: //next
				case 7: //next
				case 8: //next
				case 10: //next
				case 12:
					dia = (int)(Math.random()*31+1);
					break;
				case 4: //next
				case 6: //next
				case 9: //next
				case 11:
					dia = (int)(Math.random()*30+1);
					break;
				case 2:
					dia = (int)(Math.random()*28+1);
					break;
			}
			contador = contador+1;
		}
		return contador;
	}

	public int numRandomTriesEqualDate2(){
		int contador, dia, mes;
		contador = 0;
		dia = 0;
		mes = 0;
		do{
			mes = (int)(Math.random()*12+1);
			switch(mes){
				case 1: //next
				case 3: //next
				case 5: //next
				case 7: //next
				case 8: //next
				case 10: //next
				case 12:
					dia = (int)(Math.random()*31+1);
					break;
				case 4: //next
				case 6: //next
				case 9: //next
				case 11:
					dia = (int)(Math.random()*30+1);
					break;
				case 2:
					dia = (int)(Math.random()*28+1);
					break;
			}
			contador = contador+1;
		} while(dia!=this.day || mes!=this.month);
		return contador;
	}

	public int dayOfWeek(int dayFirstWeek){
		int dOW;
		dOW = this.daysPast()%7+dayFirstWeek-1;
		if(dOW>7){
			dOW = dOW-7;
		}
		return dOW;
	}

}
