import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.fragmenttransaction.R

// InputFragment.kt
class InputFragment : Fragment(R.layout.fragment_input) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Find UI elements in the fragment's layout
        val inputText = view.findViewById<EditText>(R.id.inputText)
        val submitButton = view.findViewById<Button>(R.id.submitButton)

        // Set up a click listener for the submit button
        submitButton.setOnClickListener {
            // Get user input from the EditText
            val userInput = inputText.text.toString()
            // Navigate to DisplayFragment with user input
            navigateToDisplayFragment(userInput)
        }
    }

    // Function to navigate to DisplayFragment with user input
    private fun navigateToDisplayFragment(userInput: String) {
        // Create an instance of DisplayFragment with arguments
        val displayFragment = DisplayFragment.newInstance(userInput)
        // Start a FragmentTransaction
        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        // Replace the current fragment with DisplayFragment
        transaction.replace(R.id.fragmentContainer, displayFragment)
        // Add the transaction to the back stack
        transaction.addToBackStack(null)
        // Commit the transaction
        transaction.commit()
    }
}
