package com.esprit.spring.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.esprit.spring.entites.BankAccountInfo;
import com.esprit.spring.entites.Jackpot;
import com.esprit.spring.repository.BankAccountRepository;
import com.esprit.spring.repository.BankTransactionException;
 
@Controller
public class BankAccountController {
 
    @Autowired
    private BankAccountRepository bankAccountRepository;
 
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showBankAccounts(Model model) {
        List<BankAccountInfo> list = bankAccountRepository.listBankAccountInfo();
 
        model.addAttribute("accountInfos", list);
 
        return "accountsPage";
    }
 
    @RequestMapping(value = "/sendMoney", method = RequestMethod.GET)
    public String viewSendMoneyPage(Model model) {
 
        Jackpot form = new  Jackpot ();
 
        model.addAttribute("sendMoneyForm", form);
 
        return "sendMoneyPage";
    }
 
  
    @RequestMapping(value = "/sendMoney", method = RequestMethod.POST)
    public String processSendMoney(Model model,  Jackpot  sendMoneyForm) {
 
        System.out.println("Send Money: " + sendMoneyForm.getAmount());
 
        try {
            bankAccountRepository.sendMoney(sendMoneyForm.getFromAccountId(), //
                    sendMoneyForm.getToAccountId(), //
                    sendMoneyForm.getAmount());
        } catch (BankTransactionException e) {
            model.addAttribute("errorMessage", "Error: " + e.getMessage());
            return "/sendMoneyPage";
        }
        return "redirect:/";
    }

	public BankAccountRepository getBankAccountRepository() {
		return bankAccountRepository;
	}

	public void setBankAccountRepository(BankAccountRepository bankAccountRepository) {
		this.bankAccountRepository = bankAccountRepository;
	}
 
}
