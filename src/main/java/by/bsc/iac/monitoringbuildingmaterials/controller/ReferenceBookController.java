package by.bsc.iac.monitoringbuildingmaterials.controller;

import by.bsc.iac.monitoringbuildingmaterials.entity.Unit;
import by.bsc.iac.monitoringbuildingmaterials.service.IUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/reference_book")
public class ReferenceBookController {

    @Autowired
    IUnitService unitService;

    @GetMapping("/unit")
    public String showAllUnits(Model model) {
        List<Unit> unitList = unitService.findAll();
        model.addAttribute("allUnits", unitList);
        return "referenceBooks/units_all";
    }

    @GetMapping("/unit/addNewUnit")
    public String addNewUnit(Model model) {
        Unit unit = new Unit();
        model.addAttribute("unit", unit);
        return "referenceBooks/unit_info";
    }

    @GetMapping("/unit/saveUnit")
    public String saveUnit(@ModelAttribute("unit") Unit unit) {
        unitService.saveOrUpdate(unit);
        return "redirect:/reference_book/unit";
    }

    @GetMapping("*/international")
    public String getInternationalPage(HttpServletRequest request){
        return new PageController().getInternationalPage(request);
    }

}
