package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.VueloInternacional;
import co.edu.unbosque.model.VueloInternacionalDTO;
import co.edu.unbosque.model.VueloNacional;
import co.edu.unbosque.model.VueloNacionalDTO;

public class DataMapper {

	public static VueloInternacional vueloInternacionalDTOToVueloInternacional(VueloInternacionalDTO dto) {
		VueloInternacional entity = new VueloInternacional(dto.getCompanyInCharge(), dto.getNumPassengers(),
				dto.getCaptain(), dto.getSecondInCommand(), dto.getArrivalTime(), dto.getDepartureTime(), dto.getGas(),
				dto.isRequiereVisa());
		return entity;
	}

	public static VueloInternacionalDTO vueloInternacionalToVueloInternacionalDTO(VueloInternacional entity) {
		VueloInternacionalDTO dto = new VueloInternacionalDTO(entity.getCompanyInCharge(), entity.getNumPassengers(),
				entity.getCaptain(), entity.getSecondInCommand(), entity.getArrivalTime(), entity.getDepartureTime(),
				entity.getGas(), entity.isRequiereVisa());
		return dto;
	}

	public static ArrayList<VueloInternacional> listaVInternacionalesDTOToListaVuelosInternacionales(
			ArrayList<VueloInternacionalDTO> dtoList) {
		ArrayList<VueloInternacional> entityList = new ArrayList<>();

		for (VueloInternacionalDTO dto : dtoList) {
			entityList.add(new VueloInternacional(dto.getCompanyInCharge(), dto.getNumPassengers(), dto.getCaptain(),
					dto.getSecondInCommand(), dto.getArrivalTime(), dto.getDepartureTime(), dto.getGas(),
					dto.isRequiereVisa()));
		}
		return entityList;

	}

	public static ArrayList<VueloInternacionalDTO> listaVInternacionalesToListaVuelosInternacionalesDTO(
			ArrayList<VueloInternacional> entityList) {
		ArrayList<VueloInternacionalDTO> dtoList = new ArrayList<>();
		for (VueloInternacional entity : entityList) {
			dtoList.add(new VueloInternacionalDTO(entity.getCompanyInCharge(), entity.getNumPassengers(),
					entity.getCaptain(), entity.getSecondInCommand(), entity.getArrivalTime(),
					entity.getDepartureTime(), entity.getGas(), entity.isRequiereVisa()));
		}
		return dtoList;
	}

	public static VueloNacional vueloNacionalDTOToVueloNacional(VueloNacionalDTO dto) {
		VueloNacional entity = new VueloNacional(dto.getCompanyInCharge(), dto.getNumPassengers(), dto.getCaptain(),
				dto.getSecondInCommand(), dto.getArrivalTime(), dto.getDepartureTime(), dto.getGas(), dto.isEsTurbina(),
				dto.isEsHelice());
		return entity;
	}

	public static VueloNacionalDTO vueloNacionalToVueloNacionalDTO(VueloNacional entity) {
		VueloNacionalDTO dto = new VueloNacionalDTO(entity.getCompanyInCharge(), entity.getNumPassengers(),
				entity.getCaptain(), entity.getSecondInCommand(), entity.getArrivalTime(), entity.getDepartureTime(),
				entity.getGas(), entity.isEsTurbina(), entity.isEsHelice());
		return dto;

	}

	public static ArrayList<VueloNacional> listaVuelosNacionalesDTOToListaVuelosNacionales(
			ArrayList<VueloNacionalDTO> dtoList) {
		ArrayList<VueloNacional> entityList = new ArrayList<>();

		for (VueloNacionalDTO dto : dtoList) {
			entityList.add(new VueloNacional(dto.getCompanyInCharge(), dto.getNumPassengers(), dto.getCaptain(),
					dto.getSecondInCommand(), dto.getArrivalTime(), dto.getDepartureTime(), dto.getGas(),
					dto.isEsTurbina(), dto.isEsHelice()));
		}
		return entityList;
	}

	public static ArrayList<VueloNacionalDTO> listaVuelosNacionalesToListaVuelosNacionalesDTO(
			ArrayList<VueloNacional> entityList) {
		ArrayList<VueloNacionalDTO> dtoList = new ArrayList<>();

		for (VueloNacional entity : entityList) {
			dtoList.add(new VueloNacionalDTO(entity.getCompanyInCharge(), entity.getNumPassengers(),
					entity.getCaptain(), entity.getSecondInCommand(), entity.getArrivalTime(),
					entity.getDepartureTime(), entity.getGas(), entity.isEsTurbina(), entity.isEsHelice()));
		}
		return dtoList;
	}

}
