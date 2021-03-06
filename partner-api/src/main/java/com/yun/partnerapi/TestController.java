package com.yun.partnerapi;

import com.yun.partnerapi.model.Currency;
import com.yun.partnerapi.partner.PartnerFactory;
import com.yun.partnerapi.partner.PartnerExchangeRate;
import com.yun.partnerapi.partner.PartnerManagerDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("test")
@AllArgsConstructor
public class TestController {

    private final PartnerFactory partnerFactory;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public PartnerManagerDto.ExchangeRate test(@RequestBody PartnerManagerDto.ExchangeCurrency dto) {
        final Currency dstCurrency = dto.getDstCurrency();
        PartnerExchangeRate partnerExchangeRate = partnerFactory.getInstance(dstCurrency);
        return partnerExchangeRate.get(dto);

    }

}
