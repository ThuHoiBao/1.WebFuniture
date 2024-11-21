package DAO;

import business.Furniture;

import java.util.List;

public interface IFurnitureDAO {
    List<Furniture> getFurnituresByOrderId(Long orderId);
}
