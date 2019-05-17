package com.piwko.dawid.searchgithubrepos.repos;

import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.piwko.dawid.searchgithubrepos.R;
import com.piwko.dawid.searchgithubrepos.model.Repo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.RepoViewHolder> {

    private final RepoClickedListener listener;
    private final List<Repo> data = new ArrayList<>();

    RepoAdapter(RepoClickedListener listener) {
        this.listener = listener;
        setHasStableIds(true);
    }

    @Override
    public RepoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(
                parent.getContext()).inflate(R.layout.view_repo_list_item,
                parent,
                false);
        return new RepoViewHolder(itemView, listener);
    }

    @Override
    public void onBindViewHolder(RepoViewHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public long getItemId(int position) {
        return data.get(position).id();
    }

    void setData(List<Repo> repos) {
        if (repos != null) {
            DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(
                    new RepoDiffCallback(data, repos));
            data.clear();
            data.addAll(repos);
            diffResult.dispatchUpdatesTo(this);
        } else {
            data.clear();
            notifyDataSetChanged();
        }
    }

    static final class RepoViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.text_view_repo_name)
        TextView repoNameText;
        @BindView(R.id.text_view_list_stargazers_count)
        TextView repoStarsCountText;
        @BindView(R.id.text_view_list_forks_count)
        TextView repoForksCountText;

        private Repo repo;

        RepoViewHolder(View itemView, RepoClickedListener listener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(v -> {
                if (repo != null) {
                    listener.onRepoClicked(repo);
                }

            });
        }

        void bind(Repo repo) {
            this.repo = repo;
            repoNameText.setText(repo.name());
            repoStarsCountText.setText(Long.toString(repo.stargazersCount()));
            repoForksCountText.setText(Long.toString(repo.forksCount()));
        }
    }

    interface RepoClickedListener {
        void onRepoClicked(Repo repo);
    }
}
