package not.dev.mymessenger.mainUi.homePaging.all

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import not.dev.mymessenger.core.base.dto.UserModel
import not.dev.mymessenger.databinding.ItemUsersBinding

class AllAdapter(private val clickListener: ((UserModel) -> Unit)) :
    ListAdapter<UserModel, AllAdapter.UserVH>(DiffCallback()) {

    inner class UserVH(
        private val binding: ItemUsersBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(userModel: UserModel) {
            with(binding) {
                personName.text = userModel.name
                textNextMessage.text = userModel.userToken
                root.setOnClickListener {
                    clickListener.invoke(userModel)
                }
            }
        }
    }

    companion object {
        class DiffCallback : DiffUtil.ItemCallback<UserModel>() {
            override fun areItemsTheSame(oldItem: UserModel, newItem: UserModel): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: UserModel, newItem: UserModel): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserVH {
        val binding = ItemUsersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserVH(binding)
    }

    override fun onBindViewHolder(holder: UserVH, position: Int) {
        holder.bind(getItem(position))
    }
}
