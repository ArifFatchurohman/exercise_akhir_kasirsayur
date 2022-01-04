/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Praktikum.java.Praktikum.java3;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author LENOVO SLIM 3
 */

@Controller
public class fileController {
    @RequestMapping("/input")
    public String getData(HttpServletRequest data,Model vegetable){
   
            String inputnama = data.getParameter("nama");
            
            String inputharga = data.getParameter("harga");
            
            String inputquantity = data.getParameter("quantity");
            
            String discount = "";
            
            Double iPrice = Double.valueOf(inputharga);
            Double iTotal = Double.valueOf(inputquantity);
            Double PriceTotal = iPrice * iTotal;
            Double getTotal = null;
        
        if (PriceTotal < 16000)
        {
            getTotal = PriceTotal - (0 * PriceTotal/100);
            discount = "0%";
        }
        else if (PriceTotal >= 16000 && PriceTotal < 25000)
        {
            getTotal = PriceTotal - (10 * PriceTotal/100);
            discount = "10%";
        }
        else if (PriceTotal >= 25000)
        {
            getTotal = PriceTotal - (15 * PriceTotal/100);
            discount = "15%";
        }
        
        vegetable.addAttribute("nama", inputnama);
        vegetable.addAttribute("harga", inputharga);
        vegetable.addAttribute("quantity", inputquantity);
        vegetable.addAttribute("total", getTotal);
        vegetable.addAttribute("discount", discount);
        
        return"view";
    }    
}
