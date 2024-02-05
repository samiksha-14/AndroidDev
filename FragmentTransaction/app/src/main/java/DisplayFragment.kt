import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.fragmenttransaction.R
// DisplayFragment.kt
class DisplayFragment : Fragment(R.layout.fragment_display) {

    companion object {
        private const val ARG_USER_INPUT = "arg_user_input"

        // Function to create a new instance of DisplayFragment with arguments
        fun newInstance(userInput: String): DisplayFragment {
            val fragment = DisplayFragment()
            val args = Bundle()
            args.putString(ARG_USER_INPUT, userInput)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val displayText = view.findViewById<TextView>(R.id.displayText)
        val userInput = arguments?.getString(ARG_USER_INPUT)

        displayText.text = "User Input: $userInput"
    }
}
