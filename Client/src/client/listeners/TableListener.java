/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.listeners;

import java.math.BigDecimal;

/**
 *
 * @author ANA
 */
public interface TableListener {
    void errorHappened(String error);
    void valueChanged(BigDecimal total);
}
