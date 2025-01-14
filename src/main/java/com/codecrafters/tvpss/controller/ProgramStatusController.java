package com.codecrafters.tvpss.controller;

import com.codecrafters.tvpss.model.ProgramStatusModel;
import com.codecrafters.tvpss.service.ProgramStatusService;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProgramStatusController {

    @Autowired
    private ProgramStatusService programStatusService;

    // Show the form for Program Status submission
    @GetMapping("/program-status")
    public String showForm(Model model) {
        model.addAttribute("programStatus", new ProgramStatusModel());
        return "program-status/program-status-form";
    }

    // Submit the Program Status form
    @PostMapping("/submitProgramStatus")
    public String submitProgramStatus(ProgramStatusModel programStatus, RedirectAttributes redirectAttributes) {
        try {
            // Build the JSON string for version criteria
            String versionCriteria = buildVersionCriteria(programStatus);
            programStatus.setVersionCriteria(versionCriteria);

            // Set default values (e.g., creation date)
            programStatus.setCreatedAt(LocalDateTime.now());

            // Save the program status to the database
            programStatusService.saveProgramStatus(programStatus);

            // Add success message
            redirectAttributes.addFlashAttribute("success", "Program status submitted successfully!");

            return "redirect:/program-status/success";
        } catch (Exception e) {
            // If an error occurs, log and add an error message
            e.printStackTrace(); // Log the error for debugging
            redirectAttributes.addFlashAttribute("error", "Failed to submit program status: " + e.getMessage());
            return "redirect:/program-status";
        }
    }

    // Helper method to build the JSON string for version criteria
    private String buildVersionCriteria(ProgramStatusModel programStatus) {
        // Ensure values for the criteria are handled properly, e.g., handle nulls
        String v1Name = programStatus.getV1_name() != null ? programStatus.getV1_name() : "No";
        String v1Logo = programStatus.getV1_logo() != null ? programStatus.getV1_logo() : "No";
        String v1Studio = programStatus.getV1_studio() != null ? programStatus.getV1_studio() : "No";

        String v2Recording = programStatus.getV2_recording() != null ? programStatus.getV2_recording() : "No";
        String v2Upload = programStatus.getV2_upload() != null ? programStatus.getV2_upload() : "No";

        String v3RecordingOut = programStatus.getV3_recording_out() != null ? programStatus.getV3_recording_out() : "No";
        String v3Collaborate = programStatus.getV3_collaborate() != null ? programStatus.getV3_collaborate() : "No";

        String v4GreenScreen = programStatus.getV4_green_screen() != null ? programStatus.getV4_green_screen() : "No";

        // Construct and return the JSON-like string
        return String.format("{\"v1_name\": \"%s\", \"v1_logo\": \"%s\", \"v1_studio\": \"%s\", " +
                        "\"v2_recording\": \"%s\", \"v2_upload\": \"%s\", \"v3_recording_out\": \"%s\", \"v3_collaborate\": \"%s\", " +
                        "\"v4_green_screen\": \"%s\"}",
                v1Name, v1Logo, v1Studio, v2Recording, v2Upload, v3RecordingOut, v3Collaborate, v4GreenScreen);
    }

    // Show the success page after form submission
    @GetMapping("/program-status/success")
    public String showSuccessPage() {
        return "program-status/program-status-submit-successful";
    }
}
